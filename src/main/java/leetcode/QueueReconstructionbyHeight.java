package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2017/4/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class QueueReconstructionbyHeight {
    public static void main(String[] args) {
        QueueReconstructionbyHeight qrh = new QueueReconstructionbyHeight();
        int[][] matrixes = new int[][]{
                {4, 4}, {5, 2}, {5, 0}, {6, 1}, {7, 1}, {7, 0}
        };
        for (int i = 0; i < matrixes.length; i++) {
            for (int j = 0; j < matrixes[0].length; j++) {
                System.out.print(matrixes[i][j] + ",");
            }
            System.out.println();
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> result = new ArrayList();
        for(int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[result.size()][2]);
    }
}
