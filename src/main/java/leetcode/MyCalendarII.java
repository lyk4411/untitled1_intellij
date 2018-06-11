package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MyCalendarII {
    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarII() {
        calendar = new ArrayList();
        overlaps = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarII mcii = new MyCalendarII();
        mcii.calendar.add(new int[]{0, 0});
        mcii.overlaps.add(new int[]{0, 0});

        System.out.println(mcii.book(10, 20));
        System.out.println(mcii.book(50, 60));
        System.out.println(mcii.book(10, 40));
        System.out.println(mcii.book(5,  15));
        System.out.println(mcii.book(5,  10));
        System.out.println(mcii.book(25, 55));
    }
}
