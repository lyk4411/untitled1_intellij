package leetcode;

/**
 * Created by lyk on 2017/5/18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TeemoAttacking {
    public static void main(String[] args) {
        TeemoAttacking ta = new TeemoAttacking();
        int[] timeSeries = new int[]{1,3,4,7};
        System.out.println(ta.findPosisonedDuration(timeSeries,3));

    }
    public int findPosisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;

        int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > end) {
                result += end - start;
                start = timeSeries[i];
            }
            end = timeSeries[i] + duration;
        }
        result += end - start;

        return result;
    }
}
