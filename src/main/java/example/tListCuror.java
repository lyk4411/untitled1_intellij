package example;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by lyk on 2018-10-11.
 * Package name: example
 * Porject name: untitled1
 */
public class tListCuror {
    private void testListItr(){
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        ListIterator<Integer> listIterator = list.listIterator(list.size());

        while (listIterator.hasPrevious()){

            if (listIterator.previous() == 2){
                listIterator.add(0);
//         listIterator.set(10); //Exception in thread "main" java.lang.IllegalStateException
            }

        }
        System.out.println("list " + list.toString());
    }

    public static void main(String[] args) {
        tListCuror tlc = new tListCuror();
        tlc.testListItr();
    }
}
