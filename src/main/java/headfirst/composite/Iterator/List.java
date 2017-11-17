package headfirst.composite.Iterator;

/**
 * Created by lyk on 2017-11-17.
 * Package name: headfirst.composite.Iterator
 * Porject name: untitled1
 */


public interface List {

    public void add(Object obj);
    public Object get(int index);
    public Iterator iterator();
    public int getSize();
}