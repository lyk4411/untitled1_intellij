package leetcode;

import java.util.HashMap;

/**
 * Created by lyk on 2019-2-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int ans = 0, i = 0;
        Counter count = new Counter();
        for (int j = 0; j < tree.length; ++j) {
            count.add(tree[j], 1);
            while (count.size() >= 3) {
                count.add(tree[i], -1);
                if (count.get(tree[i]) == 0)
                    count.remove(tree[i]);
                i++;
            }

            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fib = new FruitIntoBaskets();
        System.out.println(fib.totalFruit(new int[]{1, 2, 1}));
        System.out.println(fib.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(fib.totalFruit(new int[]{1, 2 ,3, 2, 2}));
        System.out.println(fib.totalFruit(new int[]{1, 2 ,3, 2, 3}));
        System.out.println(fib.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}

class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}
