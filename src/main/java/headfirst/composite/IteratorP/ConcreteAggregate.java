package headfirst.composite.IteratorP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorP
 * Porject name: untitled1
 */


class ConcreteAggregate implements Aggregate {
    private List list = new ArrayList();
    public void add(Object obj) {
        list.add(obj);
    }

    public Iterator iterator() {
        return new ConcreteIterator(list);
    }

    public void remove(Object obj) {
        list.remove(obj);
    }
}