package com.wenhuisoft.chapter6;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter6
 * Porject name: untitled1
 */

import java.util.LinkedList;
import java.util.List;

/**
 * thread pool itself is a thread(it not represent other programming have same * realize) * * @author wangwenjun * @date 2012-03-23
 */
public class ThreadPool extends Thread {
    private final static int DEFAUT_MIN_THREAD_SIZE = 5; /* * minimum default * thread size value */
    private final static int DEFAULT_ACTIVE_THREAD_SIZE = 8; /* * maximum default  * thread active * size value */
    private final static int DEFAULT_MAX_THREAD_SIZE = 10; /* * maximum default * thread size value */
    private int min_thread_size = 0;
    private int active_thread_size = 0;
    private int max_thread_size = 0;
    private List<Task> taskQuene = null;
    private List<ChildThread> pools = null;
    private boolean destory = false;

    public ThreadPool() {
        this(DEFAUT_MIN_THREAD_SIZE, DEFAULT_ACTIVE_THREAD_SIZE, DEFAULT_MAX_THREAD_SIZE);
    }

    public ThreadPool(int min_thread_size, int active_thread_size, int max_thread_size) {
        this.min_thread_size = min_thread_size;
        this.active_thread_size = active_thread_size;
        this.max_thread_size = max_thread_size;
        createPool();
    }

    private void createPool() {
        taskQuene = new LinkedList<Task>();
        pools = new LinkedList<ChildThread>();
        for (int i = 0; i < min_thread_size; i++) {
            ChildThread t = new ChildThread(taskQuene);
            ((LinkedList<ChildThread>) pools).add(t);
            t.start();
        }
        this.start();
    }

    private Object lock = new Object();

    public void run() {
        while (!destory) {
            if (getFreeThreadSize() >= active_thread_size) {
                ((LinkedList<ChildThread>) pools).removeLast();
                System.out.println("destory one thread");
                synchronized (lock) {
                    try {
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("task number less than active size");
                synchronized (lock) {
                    try {
                        lock.wait(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * destory thread pool and close all child thread in thread pool, close * every thread for loop
     */
    public void destory() {
        this.destory = false;// close thread pool thread
        synchronized (taskQuene) {
            for (ChildThread t : pools) {
                t.close();// close child thread one by one
                t.interrupt();
            }
        }
    }

    /**
     * <pre> * &nbsp;execute method is add a task to queue in fact * sometimes task number more than maximum thread number in pool,we have some way to deal with it * for example: * 1、we can throw an exception notify invoker thread pool is full! * 2、we can store task in a list and wait free thread hand it * 3、we also can make invoker wait some seconds and try again! * 4、others solutions * in our thread pool we use method 2 to realize it; * </pre> * * @param task * Task type * @version 1.0.0.0 * @since 1.0.0.0
     */
    public void execute(Task task) {
        int threadSize = pools.size();
        if (threadSize >= max_thread_size) { // because we use way 2 to deal with task number more than/equals
            // thread pool limit size,so we can ignore it and add it to task
            // queue
            System.out.println("more than thread pool size....");
        }
        if (threadSize >= min_thread_size && threadSize < max_thread_size) { // create new thread to process extra task
            createNewThread();
        }
        synchronized (taskQuene) {
            ((LinkedList<Task>) taskQuene).addFirst(task);
            taskQuene.notify();
        }
    }

    private void createNewThread() {
        System.out.println("begin create new thread!");
        ChildThread t = new ChildThread(taskQuene);
        ((LinkedList<ChildThread>) pools).add(t);
        t.start();
        System.out.println("new thread have creat success!");
    }

    /**
     * get thread pool current running thread size * * @return running thread size
     */
    public int getRunningThreadSize() {
        int count = 0;
        synchronized (taskQuene) {
            for (ChildThread c : pools) {
                if (c.getCurrentThreadState()) {
                    count++;
                }
            }
        }
        System.out.println("running count:" + count);
        return count;
    }

    public int getFreeThreadSize() {
        int count = 0;
        synchronized (taskQuene) {
            for (ChildThread c : pools) {
                if (!c.getCurrentThreadState()) {
                    count++;
                }
            }
        }
        System.out.println("free count:" + count);
        return count;
    }

    /**
     * <p> * every thread must implement this interface * </p> * * @author wangwenjun * @date 2012-03-23
     */
    public static interface Task {
        public void run();
    }

    /**
     * current runner state thread * * @author wangwenjun * @date 2012-03-23
     */
    private class ChildThread extends Thread {
        private boolean state = false;
        private boolean closed = false;
        private List<Task> pools = null;

        public ChildThread(List<Task> pools) {
            System.out.println("Thread Name:" + getName());
            this.pools = pools;
        }

        public void run() {
            while (!closed) {
                Task task = null;
                synchronized (pools) {
                    if (pools.isEmpty()) {
                        try {
                            pools.wait();
                        } catch (InterruptedException e) {
                        }
                    } else {
                        task = ((LinkedList<Task>) pools).removeLast();
                    }
                }
                state = true;// identify this thread is running state
                if (null != task) {
                    task.run();
                }
                state = false; /* * set this thread have finished task but no * stop */
            }
        }

        /**
         * close thread by set boolean variable
         */
        public void close() {
            closed = true;
        }

        /**
         * get worker thread current state * * @return
         */
        public boolean getCurrentThreadState() {
            return state;
        }
    }
}