package leetcode;

/**
 * Created by lyk on 2018-7-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PreimageSizeofFactorialZeroesFunction {

//
//    private static TreeSet<Integer> set = new TreeSet<>(Arrays.asList(1, 6, 31, 156, 781, 3906, 19531, 97656, 488281, 2441406, 12207031, 61035156, 305175781, 1525878906));
//
//    public int preimageSizeFZF(int K) {
//        return K == 0 ? 5 : (K == set.ceiling(K) - 1 ? 0 : preimageSizeFZF(K % set.floor(K)));
//    }

    public int preimageSizeFZF(int K) {
        long a = 0, b = Long.MAX_VALUE;
        while(a <= b) {
            long mid = a + (b - a)/2;
            long k = cal(mid);
            if (k== K)
                return 5;
            else if (k < K)
                a = mid + 1;
            else
                b = mid - 1;
        }
        return 0;
    }

    private long cal(long x) {
        long ret = 0, y = 5;
        while(x >= y) {
            ret += x / y;
            y *= 5;
        }
        return ret;
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
