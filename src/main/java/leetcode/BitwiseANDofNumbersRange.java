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
//    当m!=n，那么最末位必定等0，因为[m, n]必定包含奇偶数，相与最末位等于0。
//    可以将m，n都右移一位，记为mk、 nk，这样就相当于将[m, n]之间的所有的
//    数都右移动了一位，当m！=n 时，继续右移，当mk=nk的时候，说明之前[m, n]之
//    间的数右移一位后是相等的，右移后的数作AND操作，所以操作就可以停止了记录
//    右移的次数，offset，m>>offset即为所求结果
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
