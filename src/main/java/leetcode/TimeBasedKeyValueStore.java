package leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by lyk on 2019-7-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TimeBasedKeyValueStore {
    Map<String, List<Pair<Integer, String>>> M;

    public TimeBasedKeyValueStore() {
        M = new HashMap();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new ArrayList<Pair<Integer, String>>());

        M.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key)) return "";

        List<Pair<Integer, String>> A = M.get(key);
        int i = Collections.binarySearch(A, new Pair<Integer, String>(timestamp, "{"),
                (a, b) -> Integer.compare(a.getKey(), b.getKey()));

        if (i >= 0)
            return A.get(i).getValue();
        else if (i == -1)
            return "";
        else
            return A.get(-i-2).getValue();
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore kv = new TimeBasedKeyValueStore();
        kv.set("foo", "bar", 1);
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 1));
        System.out.println(kv.get("foo", 3));
        System.out.println(kv.get("foo", 4));
        System.out.println(kv.get("foo", 5));
        kv.set("love", "high", 10);
        kv.set("love", "low", 20);
        System.out.println(kv.get("love", 5));
        System.out.println(kv.get("love", 10));
        System.out.println(kv.get("love", 15));
        System.out.println(kv.get("love", 20));
        System.out.println(kv.get("love", 25));
    }
}
