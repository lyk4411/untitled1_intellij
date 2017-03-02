package leetcode;

import java.util.Vector;

/**
 * Created by lyk on 2017/3/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ClimbingStairs {
    public static  void  main(String[] args) {
        ClimbingStairs sc = new ClimbingStairs();
        System.out.println(sc.climbStairsRecur(10));
        System.out.println(sc.climbStairsRecur(20));

    }
    int climbStairsRecur(int n)
    {
        Vector<Integer> res = new Vector(n+1);

        res.insertElementAt(0, 0);
        res.insertElementAt(1, 1);
        res.insertElementAt(2, 2);
        for (int i = 3; i <= n; i++)
        {
            res.insertElementAt(res.get(i - 1) + res.get(i - 2),i);
        }
        return res.get(n-1);
    }
}
