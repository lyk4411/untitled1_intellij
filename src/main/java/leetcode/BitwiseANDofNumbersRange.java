package leetcode;

/**
 * Created by lyk on 2017/4/13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        BitwiseANDofNumbersRange banr = new BitwiseANDofNumbersRange();
        System.out.println(banr.rangeBitwiseAnd(101,108));
    }
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0){
            return 0;
        }
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}
