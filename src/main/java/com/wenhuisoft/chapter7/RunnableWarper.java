package com.wenhuisoft.chapter7;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter7
 * Porject name: untitled1
 */
abstract public class RunnableWarper implements Runnable {
    private ThreadListener threadListener = null;

    private final static ThreadListener DEFAULT_LISTENER = new ThreadListener() {
        private String name = Thread.currentThread().getName();

        public Object threadStart(Object[] args) {
            System.out.println(name + " start...");
            return null;
        }

        public Object threadRunning(Object[] args) {
            System.out.println(name + " running...");
            return null;
        }

        public Object threadFinish(Object[] args) {
            System.out.println(name + " finish...");
            return null;
        }

        public Object threadException(Object[] args) {
            System.out.println(name + " exception...");
            return null;
        }
    };

    public RunnableWarper() {
        this(DEFAULT_LISTENER);
    }

    public RunnableWarper(ThreadListener listener) {
        this.threadListener = listener;
    }

    public void run() {
        try {
            threadListener.threadStart(null);
            handler();
            threadListener.threadFinish(null);
        } catch (Exception e) {
            threadListener.threadException(null);
        }
    }

    abstract public void handler();
}