package JavaConcurrencyinPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lyk on 2018-12-17.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public synchronized boolean putIfAbsent(E x) {

        boolean absent = !list.contains(x);	//①
        if (absent)
            list.add(x);
        return absent;

    }

    public static void main(String[] args) throws InterruptedException {
        ListHelper<String> helper = new ListHelper<String>();
        helper.putIfAbsent("a");

        new Thread(() -> {
            helper.list.add("a");	//②
            helper.list.add("a");	//②
            helper.list.add("a");	//②

        }).start();

        Thread.sleep(1000);

        System.out.println(helper.list);
    }


}
