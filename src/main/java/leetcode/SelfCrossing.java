package leetcode;

/**
 * Created by lyk on 2018-5-31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SelfCrossing {
//    这道题给了我们一个一位数组，每个数字是个移动量，按照上左下右的顺序
//    来前进每一个位移量，问我们会不会和之前的轨迹相交，而且限定了常量的
//    空间复杂度，我立马想到了贪吃蛇游戏，但是这条蛇不会自动向前移动哈。
//    言归正传，这题我不会，参考的网上大神们的解法，实际上相交的情况只有
//    以下三种情况：
//    x(1)
//    ┌───┐
//    x(2)│   │x(0)
//    └───┼──>
//    x(3)│
//
//
//    第一类是第四条边和第一条边相交的情况，需要满足的条件是第一条
//    边大于等于第三条边，第四条边大于等于第二条边。同样适用于第五
//    条边和第二条边相交，第六条边和第三条边相交等等，依次向后类推的情况...
//
//    x(1)
//    ┌──────┐
//            │      │x(0)
//    x(2)│      ^
//            │      │x(4)
//    └──────│
//    x(3)
//
//
//    第二类是第五条边和第一条边重合相交的情况，需要满足的条件是第二条边
//    和第四条边相等，第五条边大于等于第三条边和第一条边的差值，同样适用
//    于第六条边和第二条边重合相交的情况等等依次向后类推...
//
//
//    x(1)
//    ┌──────┐
//            │      │x(0)
//    x(2)│     <│────│
//            │       x(5)│x(4)
//    └───────────│
//    x(3)
//
//
//    第三类是第六条边和第一条边相交的情况，需要满足的条件是第四条
//    边大于等于第二条边，第三条边大于等于第五条边，第五条边大于等
//    于第三条边和第一条边的差值，第六条边大于等于第四条边和第二条
//    边的差值，同样适用于第七条边和第二条边相交的情况等等依次向后
//    类推...
//
//    那么根据上面的分析，我们不难写出代码如下：
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; ++i) {
            if (x[i] >= x[i - 2] && x[i - 3] >= x[i - 1]) {
                return true;
            }
            if (i >= 4 && x[i-1] == x[i-3] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
            if (i >= 5 && x[i-2] >= x[i-4] && x[i-3] >= x[i-1] && x[i-1] >= x[i-3] - x[i-5] && x[i] >= x[i-2] - x[i-4]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SelfCrossing sc = new SelfCrossing();
        int[] x1 = new int[]{2,1,1,2};
        int[] x2 = new int[]{1,2,3,4};
        int[] x3 = new int[]{1,1,1,1};
        System.out.println(sc.isSelfCrossing(x1));
        System.out.println(sc.isSelfCrossing(x2));
        System.out.println(sc.isSelfCrossing(x3));
    }
}
