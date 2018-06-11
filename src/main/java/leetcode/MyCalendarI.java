package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-6-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MyCalendarI {
    List<int[]> calendar;

    MyCalendarI() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarI MCI = new MyCalendarI();
        System.out.println(MCI.book(10, 20));
        System.out.println(MCI.book(15, 25));
        System.out.println(MCI.book(20, 30));
    }
}
