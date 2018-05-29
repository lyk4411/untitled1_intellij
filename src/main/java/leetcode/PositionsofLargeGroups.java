package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2018-5-29.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList();
        int i = 0, N = S.length(); // i is the start of each group
        for (int j = 0; j < N; ++j) {
            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
                // Here, [i, j] represents a group.
                if (j-i+1 >= 3)
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                i = j + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdddeeeeaabbbcd";
        PositionsofLargeGroups plg = new PositionsofLargeGroups();
        System.out.println(plg.largeGroupPositions(s1));
    }
}
