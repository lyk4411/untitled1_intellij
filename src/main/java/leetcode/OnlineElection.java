package leetcode;

import java.util.TreeMap;

/**
 * Created by lyk on 2019-8-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OnlineElection {
    public TreeMap<Integer, Integer> tm = new TreeMap<>();
    public OnlineElection(int[] persons, int[] times) {
        int[] count = new int[persons.length];
        for (int i = 0, max = -1; i < times.length; ++i) {
            ++count[persons[i]];
            if (max <= count[persons[i]]) {
                max=count[persons[i]];
                tm.put(times[i], persons[i]);
            }
        }
    }
    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }
    public static void main(String[] args) {
        OnlineElection oe = new OnlineElection(
                new int[]{0,1,1,0,0,1,0},
                new int[]{0,5,10,15,20,25,30}
        );
        System.out.println(oe.tm);
        System.out.println(oe.q(3));
        System.out.println(oe.q(12));
        System.out.println(oe.q(25));
        System.out.println(oe.q(15));
        System.out.println(oe.q(24));
        System.out.println(oe.q(8));
    }
}
