package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lyk on 2017/6/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public static void main(String[] args) {
        MinimumNumberofArrowstoBurstBalloons mnabb =
                new MinimumNumberofArrowstoBurstBalloons();
        int[][] points = new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        System.out.println(mnabb.findMinArrowShots(points));
    }
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0 || points[0].length==0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]) return a[1]-b[1];
                else return a[0]-b[0];
            }
        });


        int minArrows = 1;
        int arrowLimit = points[0][1];
        for(int i=1;i<points.length;i++) {
            int[] baloon = points[i];
//            for (int j = 0; j < baloon.length; j++) {
//                System.out.print("baloon[" + j + "]:" + baloon[j] + " ");
//            }
//            System.out.println();
            if(baloon[0]<=arrowLimit) {
                arrowLimit=Math.min(arrowLimit, baloon[1]);
            } else {
                minArrows++;
                arrowLimit=baloon[1];
            }
        }
        return minArrows;
    }
}
