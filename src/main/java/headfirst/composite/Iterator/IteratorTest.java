package headfirst.composite.Iterator;

/**
 * Created by lyk on 2017-11-17.
 * Package name: headfirst.composite.Iterator
 * Porject name: untitled1
 */


public class IteratorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List list=new ConcreteAggregate();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

}