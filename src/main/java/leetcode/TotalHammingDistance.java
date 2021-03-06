package leetcode;

/**
 * Created by lyk on 2017/6/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TotalHammingDistance {
    public static void main(String[] args) {
        TotalHammingDistance thd = new TotalHammingDistance();
        int[] nums1 = new int[]{4, 14, 2};
        int[] nums2 = new int[]{1,1,1,0,2,2,2,2};
        System.out.println(thd.totalHammingDistance(nums1));
        System.out.println(thd.totalHammingDistance(nums2));
    }
//For each bit position 1-32 in a 32-bit integer, we count the number of
// integers in the array which have that bit set. Then, if there are n integers
// in the array and k of them have a particular bit set and (n-k) do not, then
// that bit contributes k*(n-k) hamming distance to the total.
    public int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j = 0; j < 32; j++) {
            int bitCount = 0;
            for (int i = 0; i < n; i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount * (n - bitCount);
        }
        return total;
    }
}