package cfets.TCPIPSocket.chapter2;

/**
 * Created by lyk on 2016/7/20.
 * Package name: cfets.TCPIPSocket.chapter2
 * Porject name: untitled1
 */

public class MyHandler {

    private MyMessageQueue queue;// 用于进行线程间通信的阻塞队列
    private CallBack callBack; // 处理消息的回调

    public MyHandler(CallBack callBack) {
        MyLooper looper = MyLooper.myLooper();
        if (looper == null) {
            throw new RuntimeException("在新开的线程中。创建MyHandler对象需要先调用MyLooper.prepare()方法。");
        }
        queue = looper.queue;
        this.callBack = callBack;
    }

    //消息接收的回调
    public interface CallBack {
        void handleMessage(MyMessage msg);
    }

    //发送消息
    public void sendMessage(MyMessage msg) {
        msg.target = this;
        queue.enqueueMessage(msg);
    }

    //派发消息
    public void dispatchMessage(MyMessage msg) {
        callBack.handleMessage(msg);
    }

}