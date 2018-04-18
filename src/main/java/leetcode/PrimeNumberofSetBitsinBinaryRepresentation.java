package leetcode;

/**
 * Created by lyk on 2018-4-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PrimeNumberofSetBitsinBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }
    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }

    public static void main(String[] args) {
        PrimeNumberofSetBitsinBinaryRepresentation pnsbbr =
                new PrimeNumberofSetBitsinBinaryRepresentation();
        int L1 = 6;
        int L2 = 10;
        int R1 = 10;
        int R2 = 15;
        System.out.println(pnsbbr.countPrimeSetBits(L1,R1));
        System.out.println(pnsbbr.countPrimeSetBits(L2,R2));
    }
}
