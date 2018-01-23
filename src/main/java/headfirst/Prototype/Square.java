package headfirst.Prototype;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.Prototype
 * Porject name: untitled1
 */

public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}