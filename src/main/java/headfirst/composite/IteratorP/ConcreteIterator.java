package headfirst.composite.IteratorP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorP
 * Porject name: untitled1
 */


class ConcreteIterator implements Iterator{
    private List list = new ArrayList();
    private int cursor =0;
    public ConcreteIterator(List list){
        this.list = list;
    }
    public boolean hasNext() {
        if(cursor==list.size()){
            return false;
        }
        return true;
    }
    public Object next() {
        Object obj = null;
        if(this.hasNext()){
            obj = this.list.get(cursor++);
        }
        return obj;
    }
}