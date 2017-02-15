package leetcode;

/**
 * Created by lyk on 2017/2/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args){

        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();

        int[] a = {1,1,1,0,0,0,0,0,1,1,0,1,1,0,1,1,2,2,2,2,2,2,2,2,2,2,2,2};
        System.out.println(mco.findMaxConsecutiveOnes(a));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
            int maxHere = 0;
            int max = 0;
            for(int n : nums){
                max = Math.max(max,maxHere = n == 0 ? 0 : maxHere +1);
            }
            return max;

    }
}
