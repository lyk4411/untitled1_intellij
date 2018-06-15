package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2018-6-15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ValidParenthesisString {
//    //Time Limit Exceeded
//    boolean checkValidString(String s) {
//        return helper(s, 0, 0);
//    }
//    boolean helper(String s, int start, int cnt) {
//        if (cnt < 0) return false;
//        for (int i = start; i < s.length(); ++i) {
//            if (s.substring(i, i + 1).equals("(")) {
//                ++cnt;
//            } else if (s.substring(i, i + 1).equals(")")) {
//                if (cnt <= 0) return false;
//                --cnt;
//            } else {
//                return helper(s, i + 1, cnt) || helper(s, i + 1, cnt + 1) || helper(s, i + 1, cnt - 1);
//            }
//        }
//        return cnt == 0;
//    }
//
//    https://leetcode.com/problems/valid-parenthesis-string/discuss/107577/short-java-on-time-o1-space-one-pass
//
//    The idea is to similar to validate a string only contains '(' and ')'. But extend it to tracking the
//    lower and upper bound of valid '(' counts. My thinking process is as following.
//
//    scan from left to right, and record counts of unpaired ‘(’ for all possible cases. For ‘(’ and ‘)’,
//    it is straightforward, just increment and decrement all counts, respectively.
//    When the character is '*', there are three cases, ‘(’, empty, or ‘)’, we can think those three cases
//    as three branches in the ongoing route.
//            Take “(**())” as an example. There are 6 chars:
//            ----At step 0: only one count = 1.
//            ----At step 1: the route will be diverted into three branches.
//    so there are three counts: 1 - 1, 1, 1 + 1 which is 0, 1, 2, for ‘)’, empty and ‘(’ respectively.
//    ----At step 2 each route is diverged into three routes again. so there will be 9 possible routes now.
//    -- For count = 0, it will be diverted into 0 – 1, 0, 0 + 1, which is -1, 0, 1, but when the count is -1,
//    that means there are more ‘)’s than ‘(’s, and we need to stop early at that route, since it is invalid.
//    we end with 0, 1.
//            -- For count = 1, it will be diverted into 1 – 1, 1, 1 + 1, which is 0, 1, 2
//            -- For count = 2, it will be diverted into 2 – 1, 2, 2 + 1, which is 1, 2, 3
//    To summarize step 2, we end up with counts of 0,1,2,3
//            ----At step 3, increment all counts --> 1,2,3,4
//            ----At step 4, decrement all counts --> 0,1,2,3
//            ----At step 5, decrement all counts --> -1, 0,1,2, the route with count -1 is invalid, so stop
//    early at that route. Now we have 0,1,2.
//    In the very end, we find that there is a route that can reach count == 0. Which means all ‘(’ and ‘)’
//    are cancelled. So, the original String is valid.
//    Another finding is counts of unpaired ‘(’ for all valid routes are consecutive integers. So we only need
//    to keep a lower and upper bound of that consecutive integers to save space.
//    One case doesn’t show up in the example is: if the upper bound is negative, that means all routes have
//    more ‘)’ than ‘(’ --> all routes are invalid --> stop and return false.
//    下面这种解法是论坛上排第一的解法，感觉思路清新脱俗，博主研究了好久，参考了网友的留言才稍稍弄懂了一些，
//    这里维护了两个变量low和high，其中low表示在有左括号的情况下，将星号当作右括号时左括号的个数(这样做的原
//    因是尽量不多增加右括号的个数)，而high表示将星号当作左括号时左括号的个数。是不是很绕，没办法。那么当high
//    小于0时，说明就算把星号都当作左括号了，还是不够抵消右括号，返回false。而当low大于0时，说明左括号的个数太
//    多了，没有足够多的右括号来抵消，返回false。那么开始遍历字符串，当遇到左括号时，low和high都自增1；当遇到
//    右括号时，只有当low大于0时，low才自减1，保证了low不会小于0，而high直接自减1；当遇到星号时，只有当low大
//    于0时，low才自减1，保证了low不会小于0，而high直接自增1，因为high把星号当作左括号。当此时high小于0，说明
//    右括号太多，返回false。当循环退出后，我们看low是否为0，参见代码如下：
//    public boolean checkValidString(String s) {
//        int low = 0;
//        int high = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                low++;
//                high++;
//            } else if (s.charAt(i) == ')') {
//                if (low > 0) {//有可能之前有星号，所以允许可能为0。
//                    low--;
//                }
//                high--;
//            } else {
//                if (low > 0) { //星号，可以做空格，不减。
//                    low--;
//                }
//                high++;
//            }
//            if (high < 0) {
//                return false;
//            }
//        }
//        return low == 0;
//    }

    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i + 1).equals("*")) star.push(i);
            else if(s.substring(i, i + 1).equals("(")) left.push(i);
            else {
                if(left.empty() && star.empty()) return false;
                if(!left.empty()) left.pop();
                else star.pop();
            }
        }
        while (!left.empty() && !star.empty()){
            if (left.peek() > star.peek()) return false;
            left.pop();
            star.pop();
        }
        return left.empty();
    }

        public static void main(String[] args) {
            ValidParenthesisString vps = new ValidParenthesisString();
            System.out.println(vps.checkValidString(")("));
            System.out.println(vps.checkValidString("()"));
            System.out.println(vps.checkValidString("(*)"));
            System.out.println(vps.checkValidString("(*))"));
    }
}
