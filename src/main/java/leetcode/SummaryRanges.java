package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        int[] nums = new int[]{1,2,3,4,6,7,9,10,12};
        System.out.println(sr.summaryRanges(nums));
    }
    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList();
        if(nums.length==1){
            list.add(nums[0]+"");
            return list;
        }
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
                i++;
            }
            if(a!=nums[i]){
                list.add(a+"->"+nums[i]);
            }else{
                list.add(a+"");
            }
        }
        return list;
    }
}
