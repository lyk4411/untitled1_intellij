package leetcode;

import static java.lang.Integer.max;

/**
 * Created by lyk on 2018-6-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DeleteandEarn {

//    这道题给了我们一个数组，每次让我们删除一个数字，删除的数字本身变为了积分累积，
//    并且要同时移除之前数的加1和减1的数，但此时移除的数字不累计积分，让我们求最多
//    能获得多少积分。博主最开始尝试的方法是积分大小来排列，先删除大的数字，但是不
//    对。于是乎，博主发现相同的数字可以同时删除，于是就是建立了每个数字和其出现次
//    数之间的映射，然后放到优先队列里，重写排序方式comparator为数字乘以其出现次数，
//    先移除能产生最大积分的数字，可是还是不对。其实这道题跟之前那道House Robber的
//    本质是一样的，那道题小偷不能偷相邻的房子，这道题相邻的数字不能累加积分，是不
//    是一个道理？那么对于每一个数字，我们都有两个选择，拿或者不拿。如果我们拿了当
//    前的数字，我们就不能拿之前的数字（如果我们从小往大遍历就不需要考虑后面的数字），
//    那么当前的积分就是不拿前面的数字的积分加上当前数字之和。如果我们不拿当前的数字，
//    那么对于前面的数字我们既可以拿也可以不拿，于是当前的积分就是拿前面的数字的积分
//    和不拿前面数字的积分中的较大值。这里我们用take和skip分别表示拿与不拿上一个数字，
//    takei和skipi分别表示拿与不拿当前数字，每次更新完当前的takei和skipi时，也要更新
//    take和skip，为下一个数字做准备，最后只要返回take和skip中的较大值即可，参见代码
//    如下：
//    public int deleteAndEarn(int[] nums) {
//        int[] sums = new int[10001];
//        for (int num: nums) sums[num] += num;
//        int take = 0, skip = 0;
//        for (int i = 0; i < 10001; ++i) {
//            int takei = skip + sums[i];
//            int skipi = max(skip, take);
//            take = takei;
//            skip = skipi;
//        }
//        return max(skip, take);
//    }
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[10001];
        for (int num: nums) sums[num] += num;
        for (int i = 2; i < 10001; ++i) {
            sums[i] = max(sums[i - 1], sums[i - 2] + sums[i]);
        }
        return sums[10000];
    }

        public static void main(String[] args) {
        DeleteandEarn de = new DeleteandEarn();
        int[] nums1 = new int[]{3, 4, 2};
        int[] nums2 = new int[]{2, 2, 3, 3, 3, 4};
        System.out.println(de.deleteAndEarn(nums1));
        System.out.println(de.deleteAndEarn(nums2));
    }
}
