package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2017/6/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BrickWall {
    public static void main(String[] args) {
        BrickWall bw = new BrickWall();
        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        List<Integer> row3 = new ArrayList<>();
        List<Integer> row4 = new ArrayList<>();
        List<Integer> row5 = new ArrayList<>();
        List<Integer> row6 = new ArrayList<>();
        row1.add(1);row1.add(2);row1.add(2);row1.add(1);
        row2.add(3);row2.add(1);row2.add(2);
        row3.add(1);row3.add(3);row3.add(2);
        row4.add(2);row4.add(4);
        row5.add(3);row5.add(1);row5.add(2);
        row6.add(1);row6.add(3);row6.add(1);row6.add(1);
        wall.add(row1);
        wall.add(row2);
        wall.add(row3);
        wall.add(row4);
        wall.add(row5);
        wall.add(row6);
        System.out.println(bw.leastBricks(wall));
    }

    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }
}
