package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/28.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber ln = new LargestNumber();
        int[] nums = new int[]{12,32,432,453664,453,6345,7,56,78,7656,776,865,57,8567,8};
        System.out.println(ln.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            arr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b)->(b+a).compareTo(a+b));
//        Arrays.sort(arr, new Comparator<String>(){
//            public int compare(String a, String b){
//                return (b+a).compareTo(a+b);
//            }
//        });
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }

        while(sb.charAt(0)=='0'&&sb.length()>1)
            sb.deleteCharAt(0);

        return sb.toString();
    }
}
