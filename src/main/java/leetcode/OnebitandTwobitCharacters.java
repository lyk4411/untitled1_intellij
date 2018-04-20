package leetcode;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OnebitandTwobitCharacters {
//    这道题说有两种特殊的字符，一种是两位字符，只能是二进制的11和10，
//    另一种是单个位字符，只能是二进制的0。现在给了我们一个只包含0和1的
//    数组，问我们能否将其正确的分割，使得最后一个字符是个单个位字符。这
//    道题可以使用贪婪算法来做，因为两种字符互不干扰，只要我们遍历到了
//    数字1，那么其必定是两位字符，所以后面一位也得跟着，而遍历到了数字0，
//    那么就必定是单个位字符。所以我们可以用一个变量i来记录当前遍历到的位置，
//    如果遇到了0，那么i自增1，如果遇到了1，那么i自增2，我们循环的条件
//    是i < n-1，即留出最后一位，所以当循环退出后，当i正好停留在n-1上，
//    说明最后一位是单独分割开的，因为题目中限定了最后一位一定是0，所以
//    没必要再判断了，参见代码如下：
//    下面这种解法写的更加简洁了，直接用一行代替了if..else..语句，
//    相当巧妙，当bits[i]为0时，i还是相当于自增了1，当bits[i]为1时，i相
//    当于自增了2，最后还是在循环跳出后检测i是否为n-1，参见代码如下：
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        OnebitandTwobitCharacters otc = new OnebitandTwobitCharacters();
        int[] b1 = new int[]{1, 0, 0};
        int[] b2 = new int[]{1, 1, 1, 0};
        System.out.println(otc.isOneBitCharacter(b1));
        System.out.println(otc.isOneBitCharacter(b2));
    }
}
