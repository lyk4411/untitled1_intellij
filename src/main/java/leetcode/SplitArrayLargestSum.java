package leetcode;

/**
 * Created by lyk on 2017/6/26.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        SplitArrayLargestSum sals = new SplitArrayLargestSum();
        int[] nums = new int[]{7,2,5,10,8};
        System.out.println(sals.splitArray(nums,2));
    }

    /**
     *  这个数肯定介于最大的那一个单值和所有元素只和的中间
     * */
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binarySearch(nums, m, sum, max);
    }
    //二分查找
    private long binarySearch(int[] nums, int m, long high, long low){
        long mid = 0;
        while(low < high){
            mid = (high + low)/2;
            //验证是否满足,也就是这么大的值有可能出现么
            if(valid(nums, m, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }

    /**
     * 验证这个值是否合法
     * */
    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        //是否有多余m个片段or区间，大于给定值的max的，如果有了，那么就不合法了，因为这样划分就不止m个，及max太小
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }



//    public int splitArray(int[] nums, int m)
//    {
//        int n = nums.length;
//        int[] sums = new int[n + 1];
//        int dp[][] = new int[m + 1][n + 1];
////        for (int i = 0; i < dp.length; i++) {
////            for (int j = 0; j < dp[0].length; j++) {
////                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
////            }
////            System.out.println();
////        }
//
//        for (int i = 1; i <= n; i++) {
//            sums[i] = sums[i - 1] + nums[i - 1];
//        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                dp[i][j] = Integer.MAX_VALUE;
//            }
//        }
//
//        for (int j = 1; j <= n; j++) {
//            dp[0][j] = sums[j];
//            dp[1][j] = sums[j];
//        }
//
////        for (int i = 0; i < dp.length; i++) {
////            for (int j = 0; j < dp[0].length; j++) {
////                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
////            }
////            System.out.println();
////        }
//
////        for (int i = 0; i < sums.length; i++) {
////            System.out.print("sums[" + i + "]" + sums[i] + "  :");        }
////        System.out.println();
//
//        for (int i = 2; i <= m; ++i) {
//            for (int j = 1; j <= n; ++j) {
//                for (int k = i - 1; k < j; ++k) {
//                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);
//                    dp[i][j] = Math.min(dp[i][j], val);
//                }
//            }
//        }
//
////        for (int i = 0; i < dp.length; i++) {
////            for (int j = 0; j < dp[0].length; j++) {
////                System.out.print("dp[" + i + "][" +j + "]:" + dp[i][j] + "  :");
////            }
////            System.out.println();
////        }
//        return dp[m][n];
//    }
}
