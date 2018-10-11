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


        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add("sh" + i);
        }
//        其实这里会抛出角标越界异常，为什么呢，因为 for 循环的条件
//        list.iterator().hasNext()，我们知道 list.iterator() 将会new 一个新的
//        iterator 对象，而在 new 的过程中我们将 每次 list.remove 后的 modCount
//        赋值给了新的 iterator 的 expectedModCount，所以不会抛出
//        ConcurrentModificationException 异常，而 hasNext 内部只判断了 size
//        是否等于 cursor != size 当我们删除了一半元素以后，size 变成了 5 而新的
//        list.iterator() 的 cursor 等于 0 ，0!=5 for 循环继续，那么当执行到
//        list.remove（5）的时候就会抛出角标越界了。

//        所以，注释掉 list.remove(i);也会越界。0!=9，for 循环继续，


        for (int i = 0; list.iterator().hasNext(); i++) {
//            list.remove(i);
            System.out.println("秘密" + list.get(i));
        }

    }
}
