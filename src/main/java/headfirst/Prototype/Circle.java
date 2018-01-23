package headfirst.Prototype;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Prototype
 * Porject name: untitled1
 */

public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}