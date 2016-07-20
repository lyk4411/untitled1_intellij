package activeMQ;

/**
 * Created by lyk on 2016/7/20.
 * Package name: activeMQ
 * Porject name: untitled1
 */

public class MyActiveMQDemo {
    public static void main(String[] args) {
        String url = "tcp://localhost:61616";
        String user = null;
        String password = null;
        String query = "MyQueue";


        new Thread(new MessageSender(query,url,user,password), "Name-Sender").start();
        new Thread(new MessageReceiver(query,url,user,password), "Name-Receiver").start();
    }
}