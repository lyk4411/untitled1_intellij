package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3,1));
        System.out.println(ps.getPermutation(3,2));
        System.out.println(ps.getPermutation(3,3));
    }



    public String getPermutation(int n, int k) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < k; i++) {
            np.nextPermutation(nums);
        }
        String string = Arrays.toString(nums);
        string = string.replace(",","");
        string = string.replace("[","");
        string = string.replace("]","");
        string = string.replace(" ","");
        return string;
    }
}
