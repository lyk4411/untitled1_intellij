package example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/6/29.
 * Package name: example
 * Porject name: untitled1
 */
public class testMaxArray {
    public static void main(String[] args) {
        testMaxArray ma = new testMaxArray();
        int[] nums1 = new int[]{3,4,6,5};
        int[] nums2 = new int[]{9,1,2,5,8,3};
        int[] temps = ma.maxArray(nums2,3);
        int[] temps1 = ma.maxArray1(nums2,3);
        for (int temp : temps) {
            System.out.print(temp + "  :  ");
        }
        System.out.println();
        for (int temp1 : temps1) {
            System.out.print(temp1 + "  :  ");
        }
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < k && i < nums.length; i++) {
            temp.add(nums[i]);
        }
        //System.out.println("temp: " + temp);

        if(nums.length > k) {
            for (int i = k; i < nums.length; i++){
                for (int j = 0; j < k; j++) {
                    if(nums[i] > temp.get(j)){
                        temp.remove(j);
                        //System.out.println("temp: " + temp + "   j:" + j);
                        temp.add(nums[i]);
                        //System.out.println("temp: " + temp + "   num[i]:" + nums[i]);
                        break;
                    }
                }
            }
        }
        for(int i = 0;i<temp.size();i++){
            ans[i] = temp.get(i);
        }
//        for (int i = 0, j = 0; i < n; ++i) {
//            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
//            if (j < k) ans[j++] = nums[i];
//        }
        return ans;
    }
    public int[] maxArray1(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];

        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
            if (j < k) ans[j++] = nums[i];
        }
        return ans;
    }
}
