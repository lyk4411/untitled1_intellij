package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-12-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k: count.keySet())
            if (count.get(k) > 1)
                return k;

        throw null;
    }

    public static void main(String[] args) {
        NRepeatedElementinSize2NArray nresna = new NRepeatedElementinSize2NArray();
        System.out.println(nresna.repeatedNTimes(new int[]{1, 2, 3, 3}));
        System.out.println(nresna.repeatedNTimes(new int[]{2, 1, 2, 5, 3, 2}));
        System.out.println(nresna.repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
