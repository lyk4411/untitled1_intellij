package leetcode;

/**
 * Created by lyk on 2017/5/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlices as = new ArithmeticSlices();
        System.out.println(as.numberOfArithmeticSlices(new int[]{7,7,7,7}));
        System.out.println(as.numberOfArithmeticSlices(new int[]{1,2,3,4}));
        System.out.println(as.numberOfArithmeticSlices(new int[]{1,2,3,4,5}));
        System.out.println(as.numberOfArithmeticSlices(new int[]{1,2,5,3,3}));
    }
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, sum = 0;
        for (int i=2; i<A.length; i++)
            if (A[i]-A[i-1] == A[i-1]-A[i-2]) {
                curr += 1;
                sum += curr;
            } else {
                curr = 0;
            }
        return sum;
    }
}
