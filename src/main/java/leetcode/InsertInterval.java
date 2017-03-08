package leetcode;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
class Interval {
         int start;
         int end;
         Interval() {
             start = 0;
             end = 0;
         }
         Interval(int s, int e) {
             start = s;
             end = e;
         }

    @Override
    public String toString() {
        return "[start:" + this.start + "; end:" + this.end + "]";
    }
}
public class InsertInterval {
    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        Interval i1 = new Interval(1,2);
        Interval i2 = new Interval(3,5);
        Interval i3 = new Interval(6,7);
        Interval i4 = new Interval(8,11);
        Interval i5 = new Interval(13,21);
        Interval newInterval = new Interval(8,15);
        ArrayList<Interval> als = new ArrayList<>();
        als.add(i1);
        als.add(i2);
        als.add(i3);
        als.add(i4);
        als.add(i5);

        System.out.println(ii.insert(als,newInterval));
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals==null||newInterval==null) {
            return intervals;
        }

        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }

        ListIterator<Interval> it = intervals.listIterator();

        while(it.hasNext()) {
            Interval tmpInterval = it.next();
            if(newInterval.end<tmpInterval.start) {
                it.previous();
                it.add(newInterval);
                return intervals;
            } else {
                if(tmpInterval.end<newInterval.start) {
                    continue;
                } else {
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
