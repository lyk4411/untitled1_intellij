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
    //这道题给的提示是用贪婪算法，那么我们首先给课程排个序，按照结束时间的顺序来排序，
    // 我们维护一个当前的时间，初始化为0，再建立一个优先数组，然后我们遍历每个课程，
    // 对于每一个遍历到的课程，当前时间加上该课程的持续时间，然后将该持续时间放入优先
    // 数组中，然后我们判断如果当前时间大于课程的结束时间，说明这门课程无法被完成，我
    // 们并不是直接减去当前课程的持续时间，而是取出优先数组的顶元素，即用时最长的一门
    // 课，这也make sense，因为我们的目标是尽可能的多上课，既然非要去掉一门课，那肯定
    // 是去掉耗时最长的课，这样省下来的时间说不定能多上几门课呢，最后返回优先队列中元素
    // 的个数就是能完成的课程总数啦，参见代码如下：
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
