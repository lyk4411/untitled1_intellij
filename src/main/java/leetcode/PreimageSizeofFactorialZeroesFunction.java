package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by lyk on 2018-7-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PreimageSizeofFactorialZeroesFunction {
    //    考虑125!有多少个0？实际上是求1 * 2 * 3 * … * 125 有多少个5。
//    1, 2, 3, 4, 5, ..., 125
//
//    考虑5的倍数，有
//    5, 10, 15, 20, ..., 125
//    可以得到125 / 5 = 25个5
//    此时剩下：
//            1, 2, 3, 5, ..., 25
//    还有5的倍数，同理得到25 / 5 = 5个5
//    依次类推，能够得到1 * 2 * 3 * ... * 125中5的个数。
//
//    于是：
//    可以求出<=K的上界 upper1
//    及<= K - 1的上界 upper2
//
//    ans = upper1 - upper2
//    public int preimageSizeFZF(int K) {
////        System.out.println(count(K));
////        System.out.println(count(K - 1));
//        return (int)(count(K) - count(K - 1));
//    }
//
//    long count(int K) {
//        if (K == -1) return 0;
//        long lf = 0;
//        long rt = Integer.MAX_VALUE;
//        while (lf < rt) {
//            long mid = lf + (rt - lf + 1) / 2;
//            long cnt = 0;
//            for (long k = mid / 5; k > 0; k /= 5) cnt += k;
//            if (cnt <= K) {
//                lf = mid;
//            }
//            else{
//                rt = mid - 1;
//            }
//        }
//        return lf + 1;
//    }
//
    private static TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 6, 31, 156, 781, 3906, 19531, 97656, 488281, 2441406, 12207031, 61035156, 305175781, 1525878906));

    public int preimageSizeFZF(int K) {
        return K == 0 ? 5 : (K == set.ceiling(K) - 1 ? 0 : preimageSizeFZF(K % set.floor(K)));
    }

    public static void main(String[] args) {
        PreimageSizeofFactorialZeroesFunction psfzf = new PreimageSizeofFactorialZeroesFunction();
        System.out.println(psfzf.preimageSizeFZF(0));
//        System.out.println(psfzf.preimageSizeFZF(5));
//        System.out.println(psfzf.preimageSizeFZF(6));
//        System.out.println(psfzf.preimageSizeFZF(20));
        System.out.println(psfzf.preimageSizeFZF(1000000000));
    }
}
