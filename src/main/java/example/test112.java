package example;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lyk on 2018-4-24.
 * Package name: example
 * Porject name: untitled1
 */
public class test112 {
    public static void main(String[] s) {
        Map<String, Boolean> whoLetDogsOut = new ConcurrentHashMap<>();
        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        whoLetDogsOut.computeIfAbsent("snoop", k -> f(k));
        System.out.println(1<<2);
    }
    static boolean f(String s) {
        System.out.println("creating a value for \""+s+'"');
        return s.isEmpty();
    }
}
