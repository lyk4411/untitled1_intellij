package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2018-7-5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                a[1] != b[1] ? a[1]-b[1] : a[0] - b[0]);
//        for(int[] t: intervals){
//            for(int i: t){
//                System.out.print(i + " : ");
//            }
//            System.out.println();
//        }
        int ans = 0, p1 = -1, p2 = -1;
        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= p1){
                continue;
            } else if(intervals[i][0] > p2){
                ans += 2;
                p2 = intervals[i][1];
                p1 = p2 - 1;
            } else {
                ans += 1;
                p1 = p2;
                p2 = intervals[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SetIntersectionSizeAtLeastTwo sisalt = new SetIntersectionSizeAtLeastTwo();
        System.out.println(sisalt.intersectionSizeTwo(new int[][]{
                {1, 3}, {1, 4}, {2, 5}, {3, 5}
        }));
        System.out.println(sisalt.intersectionSizeTwo(new int[][]{
                {1, 2}, {2, 3}, {2, 4}, {4, 5}
        }));
        System.out.println(sisalt.intersectionSizeTwo(new int[][]{
                {1, 3}, {5, 6}
        }));
        System.out.println(sisalt.intersectionSizeTwo(new int[][]{
                {16,18},{11,18},{15,23},{1,16},{10,16},{6,19},{18,20},
                {7,19},{10,11},{11,23},{6,7},{23,25},{1,3},{7,12},{1,13},
                {23,25},{10,22},{23,25},{0,19},{0,13},{7,12},{14,19},
                {8,17},{7,23},{4,24}
        }));
    }
}
