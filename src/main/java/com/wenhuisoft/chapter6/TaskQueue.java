package com.wenhuisoft.chapter6;

/**
 * Created by lyk on 2016/7/13.
 * Package name: com.wenhuisoft.chapter6
 * Porject name: untitled1
 */

import com.wenhuisoft.chapter6.ThreadPool.Task;

import java.util.LinkedList;
import java.util.List;

public class TaskQueue {
    private int max_value = 0;
    private int index = 0;
    private List<ThreadPool.Task> queue = new LinkedList<ThreadPool.Task>();

    public TaskQueue(int max_value) {
        if (max_value <= 0) throw new IllegalArgumentException("task queue length should not less than zero!");
        this.max_value = max_value;
    }

    public void addFirst(Task task) throws ExceedMaxException {
        if (index >= max_value)
            throw new ExceedMaxException("task queue current size: " + index + " exceed maxium value: " + max_value);
        index++;
        ((LinkedList<Task>) queue).addFirst(task);
    }

    public Task removeLast() {
        index--;
        return ((LinkedList<Task>) queue).removeLast();
    }

    class ExceedMaxException extends Exception {
        private static final long serialVersionUID = 2194487581753097550L;
        private String message;
        private Throwable t;

        public ExceedMaxException() {
            this(null, null);
        }

        public ExceedMaxException(String message) {
            this(message, null);
        }

        public ExceedMaxException(String message, Throwable t) {
            super(message, t);
            this.message = message;
            this.t = t;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Throwable getT() {
            return t;
        }

        public void setT(Throwable t) {
            this.t = t;
        }
    }
}