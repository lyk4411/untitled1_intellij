package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
        int[] nums = new int[]{8,7,6,5,4,3,2,1,2};
        System.out.println(fdn.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;
    }
//    public int findDuplicate(int[] nums) {
//        int l=1,r=nums.length-1;
//        while(l<r){
//            int m=(l+r)/2;
//            int c=0;
//
//            for(int i: nums){
//                if(i<=m){
//                    c++;
//                }
//            }
//
//            //if c < m,
//            if(c>m){
//                r=m;
//            }else{
//                l=m+1;
//            }
//        }
//
//        return r;
//    }
}
