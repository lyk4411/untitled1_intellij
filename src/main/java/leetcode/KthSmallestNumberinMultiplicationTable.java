package leetcode;

/**
 * Created by lyk on 2018-7-6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthSmallestNumberinMultiplicationTable {

//    解题思路：
//    从1到k进行二分枚举，上下界分别为lo, hi，记当前枚举数字为mid
//    利用O(n)的代价求乘法表中有多少个数字不大于mid，记为count
//    若count >= k，则令hi = mid - 1
//    否则，令lo = mid + 1
//    最后返回lo

    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        KthSmallestNumberinMultiplicationTable ksnmt = new KthSmallestNumberinMultiplicationTable();
        System.out.println(ksnmt.findKthNumber(3, 3, 5));
        System.out.println(ksnmt.findKthNumber(2, 3, 6));
    }
}
