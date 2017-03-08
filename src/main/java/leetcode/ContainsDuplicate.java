package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] nums = new int[]{1,2,3,4,5,1};
        cd.containsDuplicate(nums);
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:nums){
            if(set.add(i)){
                continue;
            } else {
                return true;
            }
        }
        return false;
    }
}
