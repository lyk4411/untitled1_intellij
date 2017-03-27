package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        FindtheDuplicateNumber fdn = new FindtheDuplicateNumber();
        int[] nums = new int[]{1,2,3,4,5,6,7,8,1};
        System.out.println(fdn.findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int l=1,r=nums.length-1;
        while(l<r){
            int m=(l+r)/2;
            int c=0;

            for(int i: nums){
                if(i<=m){
                    c++;
                }
            }

            //if c < m,
            if(c>m){
                r=m;
            }else{
                l=m+1;
            }
        }

        return r;
    }
}
