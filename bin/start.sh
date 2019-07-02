#!/usr/bin/env bash

if [ -z "${JAVA_HOME}" ]; then
  echo "JAVA_HOME not found!"
  exit -1
fi

JAR_NAME="hyr-hfs"  #如果是jar方式启动，必须与jar文件名相同

# 变量定义规则，如果没有可删除或将变量值设置为""
# java参数
# JAVA_OPTS="-Xmx3550m"
JAVA_OPTS=""
# gc参数
# CUR_DATE=`date +%Y%m%d`
# GC_OPTS="-XX:+UseG1GC -XX:MaxGCPauseMillis=800 -Xloggc:/data/cloud/logs/${JAR_NAME}_${CUR_DATE}_gc.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+PrintHeapAtGC -XX:+HeapDumpBeforeFullGC -XX:+PrintClassHistogramBeforeFullGC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/cloud/logs/${JAR_NAME}_${CUR_DATE}_oom_dump.log"
GC_OPTS=""

case $1 in
    start)
        if [ `jps | grep ${JAR_NAME}.jar  | wc -l` -gt 0 ];then
            echo "WARN: hfs service is already running, please stop it first!"
            exit -1
        fi
        #启动程序
        nohup java  -jar ${JAVA_OPTS} ${GC_OPTS} ${PROJECT_DIR}/lib/${JAR_NAME}.jar >>/dev/null 2>&1 &
        if [ `jps | grep ${JAR_NAME}.jar  | wc -l` -le 0 ];then
             echo "WARN: hfs service start failed, please check!"
             exit -1
        else
              echo "hfs service has started."
        fi
    ;;
    stop)
        jps | awk '{if($2=="hyr-hfs.jar") print $1}' | xargs kill -15
        echo "hfs service has stopped."
    ;;
    status)
        if [ `jps | grep ${JAR_NAME}.jar | wc -l` -le 0 ];then
             echo "hfs service hasn't running."
             exit -1
        else
              echo "hfs service has running."
        fi
    ;;
    restart)
        sh $0 stop
        sh $0 start
    ;;
    *)
        echo "Usage: sh start.sh {start|stop|status|restart}"
    ;;
esac