package leetcode;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber sun = new SuperUglyNumber();
        int[] primes = new int[]{2,3,5,7};
        System.out.println(sun.nthSuperUglyNumber(16,primes));
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] res = new int[n];
        int[] index = new int[len];
        res[0] =1;
        if(n<=1) return res[0];
        for(int i=1;i<n;i++) {
            int num = Integer.MAX_VALUE;
            for(int j=0;j<len;j++) {
                num = Math.min(num, primes[j] * res[index[j]]);
            }
            res[i] = num;
            for(int j=0;j<len;j++) {
                if(res[i] % primes[j]==0) index[j]++;
            }
//            for (int j = 0; j < index.length; j++) {
//                System.out.print(index[j] + "=");
//            }
//            System.out.print(res[i]);
//            System.out.println();
        }
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + ":");
//        }
//        System.out.println();
        return res[n-1];
    }
}


