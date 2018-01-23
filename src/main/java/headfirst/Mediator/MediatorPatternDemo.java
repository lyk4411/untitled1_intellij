package headfirst.Mediator;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Mediator
 * Porject name: untitled1
 */

public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}