package headfirst.flyweight;

import java.util.HashMap;

/**
 * Created by lyk on 2018-1-23.
 * Package name: headfirst.flyweight
 * Porject name: untitled1
 */

public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle)circleMap.get(color);

        if(circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}