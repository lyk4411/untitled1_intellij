package leetcode;

/**
 * Created by lyk on 2018-7-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountDifferentPalindromicSubsequences {
//    我们再来看一种迭代的写法，使用一个二维的dp数组，其中dp[i][j]表示子字符串[i, j]中的不同回文子序列的个数，
//    我们初始化dp[i][i]为1，因为任意一个单个字符就是一个回文子序列，其余均为0。这里的更新顺序不是正向，也不
//    是逆向，而是斜着更新，对于"bccb"的例子，其最终dp数组如下，我们可以看到其更新顺序分别是红-绿-蓝-橙。
//
//    b c c b
//    b 1 2 3 6
//    c 0 1 2 3
//    c 0 0 1 2
//    b 0 0 0 1
//
//    这样更新的好处是，更新当前位置时，其左，下，和左下位置的dp值均已存在，而当前位置的dp值需要用到这三个位置
//    的dp值。我们观察上面的dp数组，可以发现当S[i]不等于S[j]的时候，
//    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]，即当前的dp值等于左边值加下边值减去左下值，因
//    为算左边值的时候包括了左下的所有情况，而算下边值的时候也包括了左下值的所有情况，那么左下值就多算了一遍，
//    所以要减去。而当S[i]等于S[j]的时候，情况就比较复杂了，需要分情况讨论，因为我们不知道中间还有几个和S[i]相
//    等的值。举个简单的例子，比如"aba"和"aaa"，当i = 0, j = 2的时候，两个字符串均有S[i] == S[j]，此时二者都新
//    增两个子序列"a"和"aa"，但是"aba"中间的"b"就可以加到结果res中，而"aaa"中的"a"就不能加了，因为和外层的单独
//    "a"重复了。我们的目标就要找到中间重复的"a"。所以我们让left = i + 1, right = j - 1，然后对left进行while循
//    环，如果left <= right, 且S[left] != S[i]的时候，left向右移动一个；同理，对right进行while循环，如果
//    left <= right, 且S[right] != S[i]的时候，left向左移动一个。这样最终left和right值就有三种情况：
//
//            1. 当left > righ时，说明中间没有和S[i]相同的字母了，就是"aba"这种情况，那么就有
//               dp[i][j] = dp[i + 1][j - 1] * 2 + 2，其中dp[i + 1][j - 1]是中间部分的回文子序列个数，为啥要
//               乘2呢，因为中间的所有子序列可以单独存在，也可以再外面包裹上字母a，所以是成对出现的，要乘2。
//               加2的原因是外层的"a"和"aa"也要统计上。
//
//            2. 当left = right时，说明中间只有一个和S[i]相同的字母，就是"aaa"这种情况，那么有
//               dp[i][j] = dp[i + 1][j - 1] * 2 + 1，其中乘2的部分跟上面的原因相同，加1的原因是单个字母"a"的情
//               况已经在中间部分算过了，外层就只能再加上个"aa"了。
//
//            3. 当left < right时，说明中间至少有两个和S[i]相同的字母，就是"aabaa"这种情况，那么有
//               dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1]，其中乘2的部分跟上面的原因相同，要减
//               去left和right中间部分的子序列个数的原因是其被计算了两遍，要将多余的减掉。
//
//    参见代码如下：
    public int countPalindromicSubsequences(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        char[] chs = s.toCharArray();
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;   // Consider the test case "a", "b" "c"...
        }

        for(int distance = 1; distance < len; distance++){
            for(int i = 0; i < len - distance; i++){
                int j = i + distance;
                if(chs[i] == chs[j]){
                    int low = i + 1;
                    int high = j - 1;

              /* Variable low and high here are used to get rid of the duplicate*/

                    while(low <= high && chs[low] != chs[j]){
                        low++;
                    }
                    while(low <= high && chs[high] != chs[j]){
                        high--;
                    }
                    if(low > high){
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    }
                    else if(low == high){
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    }
                    else{
                       dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }
                }
                else{
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];  //s.charAt(i) != s.charAt(j)
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        CountDifferentPalindromicSubsequences cdps = new CountDifferentPalindromicSubsequences();
        System.out.println(cdps.countPalindromicSubsequences("bccb"));
        System.out.println(cdps.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
    }
}
