package JavaConcurrencyinPractice;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by lyk on 2019-1-16.
 * Package name: JavaConcurrencyinPractice
 * Porject name: untitled1
 */


public class App {
    public static void main(String[] args) throws Exception {
        AtomicReferenceFieldUpdater updater = AtomicReferenceFieldUpdater.newUpdater(Dog.class, String.class, "name");
        Dog dog1 = new Dog();
        updater.compareAndSet(dog1, dog1.name, "test");
        System.out.println(dog1.name);
    }
}

class Dog {
    volatile String name = "dog1";
}