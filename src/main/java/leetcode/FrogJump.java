package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by lyk on 2017/6/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FrogJump {
    public static void main(String[] args) {
        FrogJump fj = new FrogJump();
        int[] stones1 = new int[]{0,1,3,5,6,8,12,17};
        int[] stones2 = new int[]{0,1,2,3,4,8,9,11};

        System.out.println(fj.canCross(stones1));
        System.out.println(fj.canCross(stones2));
    }
    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>() );
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }

        return false;
    }
}
