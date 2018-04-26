package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-4-26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;
        if (N <= 1) return N;
        int[] lengths = new int[N]; // lengths[i] = length of longest ending in nums[i]
                                    // 表示以nums[i]为结尾的递推序列的长度
        int[] counts = new int[N];  // count[i] = number of longest ending in nums[i]
                                    // 表示以nums[i]为结尾的递推序列的个数
        Arrays.fill(counts, 1);
        Arrays.fill(lengths, 1);


        for (int j = 0; j < N; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
            }
        }

        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < N; ++i) {
            if (lengths[i] == longest) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberofLongestIncreasingSubsequence nlis =
                new NumberofLongestIncreasingSubsequence();
        int[] nums1 = new int[]{1,3,5,4,7};
//        int[] nums2 = new int[]{2,2,2,2,2};
        System.out.println(nlis.findNumberOfLIS(nums1));
//        System.out.println(nlis.findNumberOfLIS(nums2));
    }
}
