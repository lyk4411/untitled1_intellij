package headfirst.composite.Component;

/**
 * Created by lyk on 2017-11-17.
 * Package name: headfirst.composite.Component
 * Porject name: untitled1
 */

abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void Add(Component c);
    public abstract void Remove(Component c);
    public abstract void Display(int depth);
}