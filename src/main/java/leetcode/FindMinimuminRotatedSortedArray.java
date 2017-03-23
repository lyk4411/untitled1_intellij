package leetcode;

/**
 * Created by lyk on 2017/3/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray fmrsa = new FindMinimuminRotatedSortedArray();
        int[] nums = new int[]{9,11,12,13,20,-9,-8,1,2,3,4,5,6,7,8};
        System.out.println(fmrsa.findMin(nums));
    }
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}
