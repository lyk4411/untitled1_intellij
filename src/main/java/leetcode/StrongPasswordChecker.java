package leetcode;

/**
 * Created by lyk on 2017/7/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StrongPasswordChecker {
    public static void main(String[] args) {
        StrongPasswordChecker spc = new StrongPasswordChecker();
        System.out.println(spc.strongPasswordChecker("MINIMUM "));
        System.out.println(spc.strongPasswordChecker("MINIMUM abc1"));
    }

    public int strongPasswordChecker(String s) {
        int res = 0, a = 1, A = 1, d = 1;
        char[] carr = s.toCharArray();
        int[] arr = new int[carr.length];

        for (int i = 0; i < arr.length;) {
            if (Character.isLowerCase(carr[i])) a = 0;
            if (Character.isUpperCase(carr[i])) A = 0;
            if (Character.isDigit(carr[i])) d = 0;

            int j = i;
            while (i < carr.length && carr[i] == carr[j]) i++;
            arr[j] = i - j;
        }

        int total_missing = (a + A + d);

        if (arr.length < 6) {
            res += total_missing + Math.max(0, 6 - (arr.length + total_missing));

        } else {
            // 用变量left表示解决重复字符最少需要替换的个数，初始化为0。
            int over_len = Math.max(arr.length - 20, 0), left_over = 0;
            // 首先我们算出超过20个的个数over，我们先把over加到结果res中，
            // 因为无论如何这over个删除操作都是要做的。
            res += over_len;
            // 对于重复字符个数k大于等于3的情况，我们并不是直接将其删除到2个，
            // 而是先将其删除到最近的(3m+2)个，那么如果k正好被3整除，那么我们
            // 直接变为k-1，如果k除以3余1，那么变为k-2。这样做的好处是3m+2个重
            // 复字符可以最高效的用替换m个字符来去除重复。

            // 如果某个字符出现个数大于等于3，且此时over大于0，那么我们将个数减
            // 为最近的3m+2个，over也对应的减少，注意，一旦over小于等于0，不要
            // 再进行删除操作。
            for (int k = 1; k < 3; k++) {
                for (int i = 0; i < arr.length && over_len > 0; i++) {
                    if (arr[i] < 3 || arr[i] % 3 != (k - 1)) continue;
                    arr[i] -= Math.min(over_len, k);
                    over_len -= k;
                }
            }

            // 如果所有重复个数都减为3m+2了，但是over仍大于0，那么我们还要进一步的
            // 进行删除操作，这回每次直接删除3m个，直到over小于等于0为止，剩下的如
            // 果还有重复个数大于3的字符，我们算出置换字符需要的个数直接加到left中
            // 即可，
            for (int i = 0; i < arr.length; i++) {
                // 消除最后剩余的oven
                // arr[i]保留2个
                if (arr[i] >= 3 && over_len > 0) {
                    int need = arr[i] - 2;
                    arr[i] -= over_len;
                    over_len -= need;
                }

                if (arr[i] >= 3) left_over += arr[i] / 3;
            }

            res += Math.max(total_missing, left_over);
        }

        return res;
    }
}
