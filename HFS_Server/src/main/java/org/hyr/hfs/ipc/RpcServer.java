package org.hyr.hfs.ipc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*******************************************************************************
 * @date 2019-06-26 11:10
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description:
 ******************************************************************************/
public class RpcServer {

    private final static Logger LOG = LoggerFactory.getLogger(RpcServer.class);

    private int port;
    private String clazz;
    private int handlerCount;
    public boolean running = true;
    private ServerSocket server = null;
    private int socketWriteTimeout = 60 * 1000;

    public RpcServer(int port, String clazz, int handlerCount) {
        this.port = port;
        this.clazz = clazz;
        this.handlerCount = handlerCount;
        try {
            server = (socketWriteTimeout > 0) ? ServerSocketChannel.open().socket() : new ServerSocket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(port);
            server.bind(inetSocketAddress, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Handler[] handlers = new Handler[handlerCount];
        for (int i = 0; i < handlerCount; i++) {
            handlers[i] = new Handler(i);
            handlers[i].start();
        }
    }

    /**
     * 实例化所有rpc服务类
     *
     * @param clazz 服务类所在包名，多个用英文逗号隔开
     * @return
     */
    public Map<String, Object> getService(String clazz) {
        try {
            Map<String, Object> services = new HashMap<String, Object>();
            //获取所有服务类
            String[] clazzes = clazz.split(",");
            List<Class<?>> classes = new ArrayList<Class<?>>();
            for (String cl : clazzes) {
                List<Class<?>> classList = getClasses(cl);
                 LOG.info("get classlist:{}",classList);
                classes.addAll(classList);
            }
            //循环实例化
            for (Class<?> cla : classes) {
                Object obj = cla.newInstance();
                services.put(cla.getAnnotation(org.hyr.hfs.annotation.RpcService.class).value().getName(), obj);
            }
            return services;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取包下所有有@RpcSercive注解的类
     *
     * @param pckgname
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Class<?>> getClasses(String pckgname) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        File directory = null;
        try {
            ClassLoader cld = Thread.currentThread().getContextClassLoader();
            if (cld == null)
                throw new ClassNotFoundException("Can't get class loader.");
            String path = pckgname.replace('.', '/');
            URL resource = cld.getResource(path);
            if (resource == null)
                throw new ClassNotFoundException("No resource for " + path);
            directory = new File(resource.getFile());
        } catch (NullPointerException x) {
            throw new ClassNotFoundException(pckgname + " (" + directory + ") does not appear to be a valid package a");
        }
        if (directory.exists()) {
            //获取所有文件
            String[] files = directory.list();
            File[] fileList = directory.listFiles();
            for (int i = 0; fileList != null && i < fileList.length; i++) {
                File file = fileList[i];
                //判断是否是Class文件
                if (file.isFile() && file.getName().endsWith(".class")) {
                    Class<?> clazz = Class.forName(pckgname + '.' + files[i].substring(0, files[i].length() - 6));
                    if (clazz.getAnnotation(org.hyr.hfs.annotation.RpcService.class) != null) {
                        classes.add(clazz);
                    }
                } else if (file.isDirectory()) { //如果是目录，递归查找
                    List<Class<?>> result = getClasses(pckgname + "." + file.getName());
                    if (result != null && result.size() != 0) {
                        classes.addAll(result);
                    }
                }
            }
        } else {
            throw new ClassNotFoundException(pckgname + " does not appear to be a valid package b");
        }
        return classes;
    }

    private class Handler extends Thread {
        public Handler(int instanceNumber) {
            this.setDaemon(true);
            this.setName("IPC Server handler " + instanceNumber + " on " + port);
        }

        @Override
        public void run() {
             LOG.info("do rpc run...");
            try {
                // 2. 获取所有rpc服务类，即发布服务
                Map<String, Object> services = getService(clazz);
                // 3. 创建线程池
                Executor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
                while (running) {
                    // 4. 获取客户端连接
                    Socket client = server.accept();
                     LOG.info("get client:" + client);
                    // 5. 查找并执行服务
                    RpcService service = new RpcService(client, services);
                    executor.execute(service);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //关闭监听
                if (server != null)
                    try {
                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}
