package leetcode;

/**
 * Created by lyk on 2017/4/19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class GuessNumberHigherorLowerII {
    public static void main(String[] args) {
        GuessNumberHigherorLowerII gnhlii = new GuessNumberHigherorLowerII();
        System.out.println(gnhlii.getMoneyAmount(100));
        System.out.println(gnhlii.getMoneyAmount(1000));
//        System.out.println(gnhlii.getMoneyAmount(10000));

    }
//    这题要求我们在猜测数字y未知的情况下（1~n任意一个数），要我们在最坏情况下我们
//    支付最少的钱。也就是说要考虑所有y的情况。
//    我们假定选择了一个错误的数x，（1<=x<=n && x!=y ）那么就知道接下来应该从
//    [1,x-1 ] 或者[x+1,n]中进行查找。 假如我们已经解决了[1,x-1] 和 [x+1,n]计算
//    问题，我们将其表示为solve(L,x-1) 和solve(x+1,n)，那么我们应该选择
//    max(solve(L,x-1),solve(x+1,n)) 这样就是求最坏情况下的损失。总的损失就是
//    f(x) = x + max(solve(L,x-1),solve(x+1,n))
//    那么将x从1~n进行遍历，取使得 f(x) 达到最小，来确定最坏情况下最小的损失，
//    也就是我们初始应该选择哪个数。
//    上面的说法其实是一个自顶向下的过程（Top-down），可以用递归来解决。
//    很容易得到如下的代码（这里用了记忆化搜索）：
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return solve(dp, 1, n);
    }
    int solve(int[][] dp, int L, int R) {
        if (L >= R) return 0;
        if (dp[L][R] != 0) return dp[L][R];
        dp[L][R] = Integer.MAX_VALUE;//0x7FFFFFFF;//INT_MAX
        for (int i = L; i <= R; i++) {
            dp[L][R] = Math.min(dp[L][R], i + Math.max(solve(dp,L,i-1),solve(dp,i+1,R)));
        }
        return dp[L][R];
    }
}
