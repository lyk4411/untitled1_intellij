package headfirst.composite.IteratorP;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorP
 * Porject name: untitled1
 */


interface Aggregate {
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator iterator();
}