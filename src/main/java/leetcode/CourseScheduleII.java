package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/7/4.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII csii = new CourseScheduleII();
        int[][] pre = new int[][]{
                {1,0},
                {2,0},
                {3,1},
                {3,2}
        };
        //int[] result1 = csii.findOrder(4,pre);
        int[] result2 = csii.findOrder(1,new int[][]{});
//        for (int i = 0; i < result1.length; i++) {
//            System.out.print(result1[i] + " > ");
//        }
        System.out.println();
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " > ");
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        if(numCourses == 0 && len == 0){
            return new int[0];
        }
        if(numCourses == 1 && len == 0  ){
            return new int[]{0};
        }


        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<len; i++){
            pCounter[prerequisites[i][0]]++;
        }
//        for (int i = 0; i < pCounter.length; i++) {
//            System.out.println(pCounter[i]);
//        }

        //store courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(pCounter[i]==0){
                queue.add(i);
            }
        }

        // number of courses that have no prerequisites
        int numNoPre = queue.size();
        int[] results = new int[numCourses];
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            int top = queue.remove();
            temp.add(top);
            for(int i=0; i<len; i++){
                // if a course's prerequisite can be satisfied by a course in queue
                if(prerequisites[i][1]==top){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]]==0){
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if(temp.size() == numCourses) {
            return temp.stream().mapToInt(i -> i).toArray();
        }
        return new int[0];
    }


}
