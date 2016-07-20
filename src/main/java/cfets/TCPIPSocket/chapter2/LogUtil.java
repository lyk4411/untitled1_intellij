package cfets.TCPIPSocket.chapter2;

/**
 * Created by lyk on 2016/7/20.
 * Package name: cfets.TCPIPSocket.chapter2
 * Porject name: untitled1
 */

public class LogUtil {

    public static void print(String msg) {
        System.out.println("Thread:" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis() + "\t" + msg);
    }
}