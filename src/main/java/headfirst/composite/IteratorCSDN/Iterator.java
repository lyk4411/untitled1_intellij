package headfirst.composite.IteratorCSDN;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorCSDN
 * Porject name: untitled1
 */


//迭代器角色（Iterator）
interface Iterator {
    Object first();
    Object next();
    boolean hasNext();
    Object currentItem();
}