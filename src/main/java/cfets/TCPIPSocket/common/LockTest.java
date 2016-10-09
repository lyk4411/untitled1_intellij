package cfets.TCPIPSocket.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lyk on 2016/8/18.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */


public class LockTest {
    public static void main(String[] args) {
        final Outputter1 output = new Outputter1();
        new Thread() {
            public void run() {
                output.output("zhangsan1111111111111111111111111111");
            };
        }.start();
        new Thread() {
            public void run() {
                output.output("lisi2222222222222222222222222222222");
            };
        }.start();
    }
}
class Outputter1 {
    private Lock lock = new ReentrantLock();// 锁对象
    public void output(String name) {
        // TODO 线程输出方法
        lock.lock();// 得到锁
        try {
            for(int i = 0; i < name.length(); i++) {
                System.out.println(name.charAt(i));
            }
        } finally {
            lock.unlock();// 释放锁
        }
    }
}
