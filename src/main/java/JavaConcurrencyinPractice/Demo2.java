package JavaConcurrencyinPractice;

/**
 * Created by lyk on 2018-12-18.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
// Demo2.java的源码
class MyThread2 extends Thread {

    public MyThread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i=0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100); // 休眠100ms
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() +" ("+this.getState()+") catch InterruptedException.");
            }
            i++;
            System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
        }
    }
}

public class Demo2 {

    public static void main(String[] args) {
        try {
            Thread t1 = new MyThread2("t1");  // 新建“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

            t1.start();                      // 启动“线程t1”
            System.out.println(t1.getName() +" ("+t1.getState()+") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令。
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted.");

            // 主线程休眠300ms，然后查看t1的状态。
            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}