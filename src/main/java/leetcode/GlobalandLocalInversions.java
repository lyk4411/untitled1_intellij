package leetcode;

import static java.lang.Integer.min;

/**
 * Created by lyk on 2018-6-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GlobalandLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        Integer temp = Integer.MAX_VALUE;
        for(int i = n -1; i >=2; i--){
            temp = min(temp,A[i]);
            if(A[i - 2] > temp)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GlobalandLocalInversions ali = new GlobalandLocalInversions();
        System.out.println(ali.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(ali.isIdealPermutation(new int[]{1, 2, 0}));
    }
}
