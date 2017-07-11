package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by lyk on 2017/7/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CourseScheduleIII {
    public static void main(String[] args) {
        CourseScheduleIII csiii = new CourseScheduleIII();
        int[][] courses = new int[][]{
                {100, 200},
                {200, 1300},
                {1000, 1250},
                {2000, 3200}
        };
        System.out.println(csiii.scheduleCourse(courses));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a, b)->a[1]-b[1]); //Sort the courses by their deadlines (Greedy! We have to deal with courses with early deadlines first)
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        int time=0;
        for (int[] c:courses)
        {
            time+=c[0]; // add current course to a priority queue
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time. (That must be the best choice!)
        }
        return pq.size();
    }
}
