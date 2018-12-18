package JavaConcurrencyinPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by lyk on 2018-12-18.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */

public class Resource3 {

    public static void main(String[] args) throws InterruptedException {
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>(a);
        Thread t = new Thread(new Runnable() {
            int count = -1;

            @Override
            public void run() {
                while (count <= 1000) {
                    list.add(count++ + "");
                }
            }
        });
        t.setDaemon(false);
        t.start();
        Thread.currentThread().sleep(3);
        for (String s : list) {
            System.out.println(list.hashCode());
            System.out.println(s);
        }
        System.out.println("===================================================");
        for (String s : a) {
            System.out.println(a.hashCode());
            System.out.println(s);
        }
    }
}