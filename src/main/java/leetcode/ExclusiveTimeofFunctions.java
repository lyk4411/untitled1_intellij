package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by lyk on 2017/7/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ExclusiveTimeofFunctions {
    public static void main(String[] args) {
        ExclusiveTimeofFunctions etf = new ExclusiveTimeofFunctions();
        List<String> logs = new ArrayList<>();
        logs.add(0,"0:end:6");
        logs.add(0,"1:end:5");
        logs.add(0,"1:start:2");
        logs.add(0,"0:start:0");

        int[] results = etf.exclusiveTime(2,logs);
        for (int i = 0; i < results.length; i++) {
            System.out.print("result:" + results[i] + "  ");
        }
        System.out.println();
    }

    public int[] exclusiveTime(int n, List< String > logs) {
        Stack < Integer > stack = new Stack< >();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
}
