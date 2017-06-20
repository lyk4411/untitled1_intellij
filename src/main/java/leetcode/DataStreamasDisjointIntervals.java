package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DataStreamasDisjointIntervals {
    public static void main(String[] args) {
        DataStreamasDisjointIntervals dsdi = new DataStreamasDisjointIntervals();
        dsdi.addNum(1);
        System.out.println(dsdi.tree);
        dsdi.addNum(3);
        System.out.println(dsdi.tree);
        dsdi.addNum(7);
        System.out.println(dsdi.tree);
        dsdi.addNum(2);
        System.out.println(dsdi.tree);
        dsdi.addNum(4);
        System.out.println(dsdi.tree);
        dsdi.addNum(6);
        System.out.println(dsdi.tree);
        dsdi.addNum(5);
        System.out.println(dsdi.tree);
        dsdi.addNum(11);
        System.out.println(dsdi.tree);
        dsdi.addNum(9);
        System.out.println(dsdi.tree);
    }
    TreeMap<Integer, Interval> tree;

    public DataStreamasDisjointIntervals() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}
