package headfirst.decorator.Person;

/**
 * Created by lyk on 2017/9/4.
 * Package name: headfirst.decorator.Person
 * Porject name: untitled1
 */

public class ManDecoratorA extends Decorator {

    public void eat() {
        super.eat();
        reEat();
        System.out.println("ManDecoratorA类");
    }

    public void reEat() {
        System.out.println("再吃一顿饭");
    }
}