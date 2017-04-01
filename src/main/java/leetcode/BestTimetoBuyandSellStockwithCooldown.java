package leetcode;

/**
 * Created by lyk on 2017/4/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public static void main(String[] args) {
        BestTimetoBuyandSellStockwithCooldown btbssc = new BestTimetoBuyandSellStockwithCooldown();
        int[] prices = new int[]{1,2,3,4,4,7,3,8,0,1,4,5,7,9,2,6,5};
        System.out.println(btbssc.maxProfit(prices));
    }

//    分析
//    https://segmentfault.com/a/1190000004193861
//    因为当前日期买卖股票会受到之前日期买卖股票行为的影响，首先考虑到用DP解决。
//
//    这道题比较麻烦的是有个cooldown的限制，其实本质也就是买与卖之间的限制。对于某一天，股票有三种状态: buy, sell, cooldown, sell与cooldown我们可以合并成一种状态，因为手里最终都没股票，最终需要的结果是sell，即手里股票卖了获得最大利润。所以我们可以用两个DP数组分别记录当前持股跟未持股的状态。然后根据题目中的限制条件，理清两个DP数组的表达式。
//
//    对于当天最终未持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天未持股状态一样，二是昨天持股了，今天卖了。所以我们只要取这两者之间最大值即可，表达式如下：
//
//    sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
//
//    对于当天最终持股的状态，最终最大利润有两种可能，一是今天没动作跟昨天持股状态一样，二是前天还没持股，今天买了股票，这里是因为cooldown的原因，所以今天买股要追溯到前天的状态。我们只要取这两者之间最大值即可，表达式如下：
//
//    buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
//
//    最终我们要求的结果是
//
//    sellDp[n - 1] 表示最后一天结束时手里没股票时的累积最大利润
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // 表示当天最终未持股的情况下，当天结束后的累计最大利润
        int[] sellDp = new int[prices.length];
        // 表示当天最终持股的情况下，当天结束后的累计最大利润
        int[] buyDp = new int[prices.length];

        // 考虑初始情况
        buyDp[0] = -prices[0];
        sellDp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            sellDp[i] = Math.max(sellDp[i - 1], buyDp[i - 1] + prices[i]);
            if (i >= 2) {
                buyDp[i] = Math.max(buyDp[i - 1], sellDp[i - 2] - prices[i]);
            } else {
                buyDp[i] = Math.max(buyDp[i - 1], -prices[i]);
            }
        }
        return sellDp[prices.length - 1];
    }



//    提示：
//    http://www.cnblogs.com/jdneo/p/5228004.html
//    这道题可以用动态规划的思路解决。但是一开始想的时候总是抽象不出状态转移方程来，之后看到了一种用状态机的思路，觉得很清晰，特此拿来分享，先看如下状态转移图：
//
//    这里我们把状态分成了三个，根据每个状态的指向，我们可以得出下面的状态转移方程：
//
//    s0[i] = max(s0[i-1], s2[i-1])
//    s1[i] = max(s1[i-1], s0[i-1] - price[i])
//    s2[i] = s1[i-1] + price[i]
//
//    这样就清晰了很多。
//    public int maxProfit(int[] prices) {
//        if(prices.length <= 1) return 0;
//        int[] s0 = new int[prices.length];
//        int[] s1 = new int[prices.length];
//        int[] s2 = new int[prices.length];
//        s1[0] = -prices[0];
//        s0[0] = 0;
//        s2[0] = Integer.MIN_VALUE;
//        for (int i = 1; i < prices.length; i++) {
//            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
//            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
//            s2[i] = s1[i - 1] + prices[i];
//        }
//        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
//    }
}
