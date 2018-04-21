package leetcode;

import java.util.HashMap;

/**
 * Created by lyk on 2018-4-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MapSumPairs {
    HashMap<String, Integer> map;
    public MapSumPairs() {
        map = new HashMap<>();
    }
    public void insert(String key, int val) {
        map.put(key, val);
    }
    public int sum(String prefix) {
        int ans = 0;
        for (String key: map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MapSumPairs msp = new MapSumPairs();
        msp.insert("apple",2);
        msp.insert("app",3);
        msp.insert("ap",1);
        System.out.println(msp.sum("a"));
        System.out.println(msp.sum("ap"));
        System.out.println(msp.sum("app"));
        System.out.println(msp.sum("appl"));
        System.out.println(msp.sum("aappl"));
    }
}
