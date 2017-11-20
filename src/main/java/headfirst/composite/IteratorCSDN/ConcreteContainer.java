package headfirst.composite.IteratorCSDN;

import java.util.List;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorCSDN
 * Porject name: untitled1
 */

class ConcreteContainer implements Container {
    private List<Object> list;

    public ConcreteContainer(List<Object> list) {
        this.list = list;
    }

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(list);
    }
}