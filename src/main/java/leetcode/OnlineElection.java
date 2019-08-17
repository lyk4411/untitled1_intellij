package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2019-8-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OnlineElection {
    List<List<Vote>> A;

    public OnlineElection(int[] persons, int[] times) {
        A = new ArrayList();
        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < persons.length; ++i) {
            int p = persons[i], t = times[i];
            int c = count.getOrDefault(p, 0) + 1;

            count.put(p, c);
            while (A.size() <= c)
                A.add(new ArrayList<Vote>());
            A.get(c).add(new Vote(p, t));
        }
    }

    public int q(int t) {
        // Binary search on A[i][0].time for smallest i
        // such that A[i][0].time > t
        int lo = 1, hi = A.size();
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A.get(mi).get(0).time <= t)
                lo = mi + 1;
            else
                hi = mi;
        }
        int i = lo - 1;

        // Binary search on A[i][j].time for smallest j
        // such that A[i][j].time > t
        lo = 0;
        hi = A.get(i).size();
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A.get(i).get(mi).time <= t)
                lo = mi + 1;
            else
                hi = mi;
        }
        int j = Math.max(lo - 1, 0);
        return A.get(i).get(j).person;
    }

    class Vote {
        int person, time;

        Vote(int p, int t) {
            person = p;
            time = t;
        }
    }

    public static void main(String[] args) {
        OnlineElection oe = new OnlineElection(
                new int[]{0,1,1,0,0,1,0},
                new int[]{0,5,10,15,20,25,30}
        );
        System.out.println(oe.q(3));
        System.out.println(oe.q(12));
        System.out.println(oe.q(25));
        System.out.println(oe.q(15));
        System.out.println(oe.q(24));
        System.out.println(oe.q(8));
    }
}
