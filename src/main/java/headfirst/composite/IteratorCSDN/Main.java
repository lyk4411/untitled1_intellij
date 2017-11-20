package headfirst.composite.IteratorCSDN;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017-11-20.
 * Package name: headfirst.composite.IteratorCSDN
 * Porject name: untitled1
 */


//客户端
public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        list.add("Android");
        list.add("PHP");
        list.add("C Language");

        Container container = new ConcreteContainer(list);
        container.add("HardWare");

        Iterator iterator = container.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}