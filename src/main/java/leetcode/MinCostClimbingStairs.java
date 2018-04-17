package leetcode;

/**
 * Created by lyk on 2018-4-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; --i) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        int[] cost1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost2 = new int[]{10, 15, 20};
        System.out.println(mccs.minCostClimbingStairs(cost1));
        System.out.println(mccs.minCostClimbingStairs(cost2));
    }
}
