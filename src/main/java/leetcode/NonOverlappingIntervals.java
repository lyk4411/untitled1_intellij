package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        NonOverlappingIntervals noi = new NonOverlappingIntervals();
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1,2);
        intervals[1] = new Interval(2,3);
        intervals[2] = new Interval(3,4);
        intervals[3] = new Interval(1,3);
        System.out.println(noi.eraseOverlapIntervals(intervals));

    }
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }

    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}
