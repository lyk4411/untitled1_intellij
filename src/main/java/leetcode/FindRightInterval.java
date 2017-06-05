package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lyk on 2017/6/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval fri = new FindRightInterval();
        Interval[] intervals1 = new Interval[1];
        Interval[] intervals2 = new Interval[3];
        intervals1[0] = new Interval(1,2);
        intervals2[0] = new Interval(1,4);
        intervals2[1] = new Interval(2,3);
        intervals2[2] = new Interval(3,4);
        //int[] result1 = fri.findRightInterval(intervals1);
        int[] result2 = fri.findRightInterval(intervals2);
//        for (int i = 0; i < result1.length; i++) {
//            System.out.print("result1[" + i + "]:" + result1[i] + "  ");
//        }
        System.out.println();
        System.out.println("==================================");
        for (int i = 0; i < result2.length; i++) {
            System.out.print("result2[" + i + "]:" + result2[i] + "  ");

        }
    }
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);
        }
        System.out.println(intervalMap);
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}
