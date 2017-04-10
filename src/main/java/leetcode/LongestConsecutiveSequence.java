package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/4/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        Arrays.sort(num);
        int[] count = new int[num.length];
        count[0] = 1;
        int max = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] == num[i-1]) count[i] = count[i-1];
            else if (num[i] == num[i-1]+1) count[i] = count[i-1]+1;
            else count[i] = 1;
            max = Math.max(max, count[i]);
        }
        return max;
    }
}
