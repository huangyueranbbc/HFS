package org.hyr.hfs.thread;

import org.hyr.hfs.server.datanode.DataProcesser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Daemon extends Thread {

    private final static Logger LOG = LoggerFactory.getLogger(Daemon.class);

    {
        setDaemon(true);                              // always a daemon
    }

    Runnable runnable = null;

    /**
     * Construct a daemon thread.
     */
    public Daemon() {
        super();
    }

    /**
     * Construct a daemon thread.
     */
    public Daemon(Runnable runnable) {
        super(runnable);
        this.runnable = runnable;
        this.setName(((Object) runnable).toString());
    }

    /**
     * Construct a daemon thread to be part of a specified thread group.
     */
    public Daemon(ThreadGroup group, Runnable runnable) {
        super(group, runnable);
        this.runnable = runnable;
        this.setName(((Object) runnable).toString());
    }

    public Runnable getRunnable() {
        return runnable;
    }
}
