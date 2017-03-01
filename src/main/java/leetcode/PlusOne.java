package leetcode;

/**
 * Created by lyk on 2017/2/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PlusOne {
    public static void main(String[] args){
        PlusOne po = new PlusOne();
        int[] d = new int[]{9,9,9,9,9,9,9};
        int[] results = po.plusOne(d);
        for(int result:results){
            System.out.println(result);
        }
    }
    public int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = digits.length - 1; i >= 0; --i) {
                if (digits[i] < 9) {
                    ++digits[i];
                    return digits;
                }
                digits[i] = 0;
            }
            int[] res = new int[n + 1];
            res[0] = 1;
            return res;
        }

}
