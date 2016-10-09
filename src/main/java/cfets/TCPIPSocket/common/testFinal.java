package cfets.TCPIPSocket.common;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by lyk on 2016/8/8.
 * Package name: cfets.TCPIPSocket.common
 * Porject name: untitled1
 */
public class testFinal {
    private final HashSet<String> hs = new HashSet<>();
    private final HashMap<String,String> hm = new HashMap<>();


    private final BigDecimal bd;
    testFinal(){
        hs.add("a");
        hs.add("b");
        hs.add("c");
        bd = new BigDecimal("123123232.123");

        hm.put("a","111");
        hm.put("b","222");
        hm.put("c","333");

    }
    public static void main(String[] args){
        testFinal tf = new testFinal();
        tf.hs.add("d");
        tf.hs.add("e");
        Iterator it = tf.hs.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        tf.hm.put("d","444");
        tf.hm.put("e","555");

        Iterator it1 = tf.hm.entrySet().iterator();

        //tf.hm = new HashMap<>();

        while(it1.hasNext()){
            HashMap.Entry entry = (HashMap.Entry) it1.next();
            System.out.print("key:" + entry.getKey());
            System.out.println("  value:" + entry.getValue());

        }

        System.out.println(String.valueOf(tf.bd));
        BigDecimal result = tf.bd.add(new BigDecimal("1234543454554"));
        System.out.println(String.valueOf(tf.bd));
        System.out.println(String.valueOf(result));

        //tf.hs = new HashSet<>();
    }
}
