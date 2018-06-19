package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-6-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        int res = 0;
        int len = answers.length;
        if (len == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        for (Integer n : map.keySet()) {
            int group = map.get(n) / (n + 1);
            if (map.get(n) % (n + 1) == 0) {
                res += group * (n + 1);
            } else {
                res += (group + 1) * (n + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RabbitsinForest rf = new RabbitsinForest();
        System.out.println(rf.numRabbits(new int[]{1, 1, 2}));
        System.out.println(rf.numRabbits(new int[]{10, 10, 10}));
        System.out.println(rf.numRabbits(new int[]{}));
    }
}
