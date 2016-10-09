package cfets.TCPIPSocket.common;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by lyk on 2016/8/16.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */
public class test {

    public static void main(String[] args) {
        HashMap<A, String> hm = new HashMap<>();
        A a = new A("aaaa");
        A b = new A("bbbb");
        A c = new A("cccc");

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("=========================");
        System.out.println(a.equals(b));
        System.out.println("=========================");


        hm.put(a, "aaaaa");
        hm.put(b, "bbbbb");
        hm.put(c, "ccccc");

        Iterator iter = hm.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iter.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            System.out.println("key:" + key + " val:" + val);
        }
    }

    public int add(int a, int b) {
        return a + b;
    }

}

class A {
    String temp;

    A(String temp) {
        this.temp = temp;
    }

    int hashcode() {
        System.out.println(this.temp +"..............hashCode");
        return 1;
    }
    boolean equals(A others){
        return true;
    }
}
