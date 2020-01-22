package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2020-1-22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int start = m * n - k % (m * n);
        LinkedList<List<Integer>> ans = new LinkedList<>();
        for (int i = start; i < m * n + start; ++i) {
            int j = i % (m * n), r = j / n, c = j % n;
            if ((i - start) % n == 0)
                ans.add(new ArrayList<>());
            ans.peekLast().add(grid[r][c]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k1 = 1;
        int[][] grid2 = new int[][]{{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
        int k2 = 4;
        int[][] grid3 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int k3 = 9;

        Shift2DGrid sg = new Shift2DGrid();
        System.out.println(sg.shiftGrid(grid1,k1));
        System.out.println(sg.shiftGrid(grid2,k2));
        System.out.println(sg.shiftGrid(grid3,k3));
    }
}
