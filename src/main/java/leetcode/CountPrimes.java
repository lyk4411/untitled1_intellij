package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
//        for (int i = 0; i < notPrime.length; i++) {
//            System.out.println(i + ":" + notPrime[i]);
//        };
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                //count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        for (int i = 2; i < notPrime.length; i++) {
            if(!notPrime[i]) count++;
        }

        return count;
    }
}
