package headfirst.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017-11-17.
 * Package name: headfirst.composite.Component
 * Porject name: untitled1
 */


class Composite extends Component {

    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void Add(Component c) {
        children.add(c);
    }

    @Override
    public void Remove(Component c) {
        children.remove(c);
    }

    @Override
    public void Display(int depth) {
        String temp = "";
        for (int i = 0; i < depth; i++)
            temp += '-';
        System.out.println(temp + name);

        for (Component c : children) {
            c.Display(depth + 2);
        }
    }

}