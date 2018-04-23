package leetcode;

/**
 * Created by lyk on 2018-4-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted mctms = new MaxChunksToMakeSorted();
        int[] nums1 = new int[]{4,3,2,1,0};
        int[] nums2 = new int[]{1,0,2,3,4};
        int[] nums3 = new int[]{1,2,0,3};
        System.out.println(mctms.maxChunksToSorted(nums1));
        System.out.println(mctms.maxChunksToSorted(nums2));
        System.out.println(mctms.maxChunksToSorted(nums3));
    }
}
