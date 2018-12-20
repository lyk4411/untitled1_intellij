package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lyk on 2018-12-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NumberofRecentCalls {
    Queue<Integer> q;
    public NumberofRecentCalls() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
//        System.out.println(q);
        while (q.peek() < t - 3000)
            q.poll();
//        System.out.println(q);
        return q.size();
    }

    public static void main(String[] args) {
        NumberofRecentCalls nrc = new NumberofRecentCalls();
        System.out.println(nrc.ping(1));
        System.out.println(nrc.ping(100));
        System.out.println(nrc.ping(3001));
        System.out.println(nrc.ping(3002));
        System.out.println(nrc.ping(3003));
    }
}
