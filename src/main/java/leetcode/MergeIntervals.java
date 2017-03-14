package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,9);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,15);
        Interval i5 = new Interval(13,21);
        ArrayList<Interval> als = new ArrayList<>();
        als.add(i5);
        als.add(i2);
        als.add(i3);
        als.add(i4);
        als.add(i1);
        MergeIntervals mi = new MergeIntervals();

        System.out.println(mi.merge(als));

    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}
