package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-4-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PyramidTransitionMatrix {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> mem = new HashMap<>();
        boolean[][] dp = new boolean[20][7];
        int n = bottom.length();

        for (String allow : allowed) {
            mem.computeIfAbsent(allow.substring(0, 2), k -> new ArrayList<>()).add(allow.substring(2));
        }
        System.out.println(mem);

        for (int i = 0; i < n; ++i) {
            dp[i][bottom.charAt(i) - 'A'] = true;
        }

        for (int i = n - 1; i >= 1; --i) {
            boolean[][] ndp = new boolean[20][7];
            for (int j = 0; j < i; ++j) {
                for (int l = 0; l < 7; ++l) {
                    for (int r = 0; r < 7; ++r) {
                        if (dp[j][l] && dp[j + 1][r]) {
                            if (mem.containsKey((char)(l + 'A') + "" + (char)(r + 'A'))) {
                                for (String s : mem.get((char)(l + 'A') + "" + (char)(r + 'A'))) {
                                    ndp[j][s.charAt(0) - 'A'] = true;
                                }
                            }
                        }
                    }
                }
            }
            dp = ndp;
        }

        for (int i = 0; i < 7; ++i) {
            if (dp[0][i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix ptm = new PyramidTransitionMatrix();
        String bottom1 = new String("XYZ");
        List<String> allowed1 = new ArrayList<>();
        String s1 = new String("XYD");
        String s2 = new String("YZE");
        String s3 = new String("DEA");
        allowed1.add(s1);
        allowed1.add(s2);
        allowed1.add(s3);
        //allowed1.add(new String("FFF"));

//        String bottom2 = new String("XXYX");
//        List<String> allowed2 = new ArrayList<>();
//        allowed2.add(new String("XXX"));
//        allowed2.add(new String("XXY"));
//        allowed2.add(new String("XYX"));
//        allowed2.add(new String("XYY"));
//        allowed2.add(new String("YXZ"));
        System.out.println(ptm.pyramidTransition(bottom1,allowed1));
//        System.out.println(ptm.pyramidTransition(bottom2,allowed2));
    }
}
