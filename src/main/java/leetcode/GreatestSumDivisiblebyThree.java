package leetcode;

/**
 * Created by lyk on 2020-1-22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GreatestSumDivisiblebyThree {
    public int maxSumDivThree(int[] nums) {
        int res = 0, leftOne = 20000, leftTwo = 20000;
        for(int n:nums){
            res+=n;
            if(n%3==1){
                leftTwo = Math.min(leftTwo,leftOne+n);
                leftOne = Math.min(leftOne,n);
            }
            if(n%3==2) {
                leftOne = Math.min(leftOne,leftTwo+n);
                leftTwo = Math.min(leftTwo,n);
            }
        }
        if(res%3==0) return res;
        if(res%3==1) return res-leftOne;
        return res - leftTwo;
    }

    public static void main(String[] args) {
        GreatestSumDivisiblebyThree gsdt = new GreatestSumDivisiblebyThree();
        int[] nums1 = new int[]{3,6,5,1,8};
        int[] nums2 = new int[]{4};
        int[] nums3 = new int[]{1,2,3,4,4};
        System.out.println(gsdt.maxSumDivThree(nums1));
        System.out.println(gsdt.maxSumDivThree(nums2));
        System.out.println(gsdt.maxSumDivThree(nums3));
    }
}
