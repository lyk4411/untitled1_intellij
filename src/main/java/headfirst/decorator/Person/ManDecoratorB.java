package headfirst.decorator.Person;

/**
 * Created by lyk on 2017/9/4.
 * Package name: headfirst.decorator.Person
 * Porject name: untitled1
 */

public class ManDecoratorB extends Decorator {

    public void eat() {
        super.eat();
        System.out.println("===============");
        System.out.println("ManDecoratorB类");
    }
}