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
        int[][] peoples = qrh.reconstructQueue(matrixes);
        for (int i = 0; i < peoples.length; i++) {
            for (int j = 0; j < peoples[0].length; j++) {
                System.out.print(peoples[i][j] + ",");
            }
            System.out.println();
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length == 0) return people;

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);


        //首先我们给队列先排个序，按照身高高的排前面，如果身高相同，则第二个数小的排前面。
        // 然后我们新建一个空的数组，遍历之前排好序的数组，然后根据每个元素的第二个数字，
        // 将其插入到res数组中对应的位置
//        for (int i = 0; i < people.length; i++) {
//            for (int j = 0; j < people[0].length; j++) {
//                System.out.print(people[i][j] + ",");
//            }
//            System.out.println();
//        }
//        System.out.println();

        List<int[]> result = new ArrayList();
        for(int[] person : people) {
            result.add(person[1], person);
        }

//        for (int i = 0; i < result.size(); i++) {
//            int[] temp = result.get(i);
//            for (int j = 0; j < temp.length; j++) {
//                System.out.print("i:" + i + " temp[j]:" + temp[j]);
//            }
//            System.out.println();
//        }
//        System.out.println();

        return result.toArray(new int[result.size()][2]);
    }
}
