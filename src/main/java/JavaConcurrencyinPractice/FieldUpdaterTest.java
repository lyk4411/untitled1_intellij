package JavaConcurrencyinPractice;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by lyk on 2019-1-16.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */

public class FieldUpdaterTest {
    //不能是static
    //不能使final
    //必须是volatile
    public volatile String match;

    public static void main(String[] args) {
        FieldUpdaterTest t = new FieldUpdaterTest();
        t.match = "str";

        AtomicReferenceFieldUpdater<FieldUpdaterTest, String> matchUpdater = AtomicReferenceFieldUpdater
                .newUpdater(FieldUpdaterTest.class, String.class, "match");

        matchUpdater.compareAndSet(t, "str", "hello");
        System.out.println(t.match);

        matchUpdater.compareAndSet(t, "a", "world");
        System.out.println(t.match);

        matchUpdater.compareAndSet(t, "str", "world");
        System.out.println(t.match);

        matchUpdater.compareAndSet(t, "hello", "hhahahahaha");
        System.out.println(t.match);
    }
}