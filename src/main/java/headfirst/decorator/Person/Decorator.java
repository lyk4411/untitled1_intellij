package headfirst.decorator.Person;

/**
 * Created by lyk on 2017/9/4.
 * Package name: headfirst.decorator.Person
 * Porject name: untitled1
 */

public abstract class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void eat() {
        person.eat();
    }
}