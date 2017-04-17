package leetcode;

/**
 * Created by lyk on 2017/4/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArrayII fmrsaii = new FindMinimuminRotatedSortedArrayII();
        int[] nums = new int[]{5,6,7,8,9,10,1,2,3,4,5};
        System.out.println(fmrsaii.findMin(nums));
    }
    public int findMin(int[] num) {
        return helper(num, 0, num.length-1);
    }
    public int helper(int[] num, int start, int end) {
        if (start == end) return num[start];
        int mid = start + (end - start) / 2;
        int left = Integer.MAX_VALUE, right = left;
        if (num[mid] >= num[end]) {
            right = helper(num, mid+1, end);
        }
        if (num[mid] <= num[end]) {
            left = helper(num, start, mid);
        }
        return Math.min(left, right);
    }
}
