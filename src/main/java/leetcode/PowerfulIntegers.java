package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyk on 2019-1-8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PowerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 18 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 18 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }

    public static void main(String[] args) {
        PowerfulIntegers pi = new PowerfulIntegers();
        System.out.println(pi.powerfulIntegers(3, 5, 15));
        System.out.println(pi.powerfulIntegers(3, 2, 10));

    }
}
