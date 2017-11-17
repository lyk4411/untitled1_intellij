package headfirst.composite.Component;

/**
 * Created by lyk on 2017-11-17.
 * Package name: headfirst.composite.Component
 * Porject name: untitled1
 */


public class CompositePattern {

    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.Add(new Leaf("Leaf A"));
        root.Add(new Leaf("Leaf B"));

        Composite compX = new Composite("Composite X");
        compX.Add(new Leaf("Leaf XA"));
        compX.Add(new Leaf("Leaf XB"));
        root.Add(compX);

        Composite compXY = new Composite("Composite XY");
        compXY.Add(new Leaf("Leaf XYA"));
        compXY.Add(new Leaf("Leaf XYB"));
        compX.Add(compXY);

        root.Display(1);
    }

}