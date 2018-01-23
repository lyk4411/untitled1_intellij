package headfirst.Prototype;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Prototype
 * Porject name: untitled1
 */

public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}