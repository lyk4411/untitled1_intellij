package headfirst.composite.IteratorCSDN;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorCSDN
 * Porject name: untitled1
 */

//容器角色（Container）
interface Container {
    void add(Object obj);
    void remove(Object obj);
    Iterator createIterator();
}