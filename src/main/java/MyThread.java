/**
 * Created by lyk on 2016/7/1.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < 60) {
            System.out.println("i:" + i++);
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}