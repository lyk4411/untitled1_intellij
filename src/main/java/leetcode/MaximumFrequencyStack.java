package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lyk on 2019-8-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumFrequencyStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public MaximumFrequencyStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if (f > maxfreq)
            maxfreq = f;

        group.computeIfAbsent(f, z-> new Stack()).push(x);
    }

    public int pop() {
        int x = group.get(maxfreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxfreq).size() == 0)
            maxfreq--;
        return x;
    }

    public static void main(String[] args) {
        MaximumFrequencyStack mfs = new MaximumFrequencyStack();
        mfs.push(5);
        mfs.push(7);
        mfs.push(5);
        mfs.push(7);
        mfs.push(4);
        mfs.push(5);
        System.out.println(mfs.pop());
        System.out.println(mfs.pop());
        System.out.println(mfs.pop());
        System.out.println(mfs.pop());
    }
}
