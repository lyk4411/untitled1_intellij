package cfets.TCPIPSocket.chapter2;

/**
 * Created by lyk on 2016/7/20.
 * Package name: cfets.TCPIPSocket.chapter2
 * Porject name: untitled1
 */


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 消息队列
 * <p>
 * Created by yutianran on 16/7/4.
 */
public class MyMessageQueue {

    private BlockingQueue<MyMessage> queue;
    private boolean quit = false;

    public MyMessageQueue() {
        queue = new LinkedBlockingQueue<>();
        queue.clear();
    }

    public boolean enqueueMessage(MyMessage msg) {
        if (msg.target == null) {
            throw new RuntimeException("消息必须有一个消息处理者");
        }
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public MyMessage next() {
        MyMessage msg = null;
        if (quit) {
            return null;
        }
        try {
            msg = queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public synchronized void quit() {
        quit = true;
    }
}