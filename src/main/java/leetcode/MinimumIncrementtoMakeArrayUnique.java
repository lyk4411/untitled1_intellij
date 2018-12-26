package leetcode;

/**
 * Created by lyk on 2018-12-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumIncrementtoMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[100000];
        for (int x: A) count[x]++;

        int ans = 0, taken = 0;

        for (int x = 0; x < 100000; ++x) {
            if (count[x] >= 2) {
                taken += count[x] - 1;
                ans -= x * (count[x] - 1);
            }
            else if (taken > 0 && count[x] == 0) {
                taken--;
                ans += x;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumIncrementtoMakeArrayUnique mimau = new MinimumIncrementtoMakeArrayUnique();
        System.out.println(mimau.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(mimau.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}
