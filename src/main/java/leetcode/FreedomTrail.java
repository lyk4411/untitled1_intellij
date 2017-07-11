package leetcode;

/**
 * Created by lyk on 2017/7/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FreedomTrail {
    public static void main(String[] args) {
        FreedomTrail ft = new FreedomTrail();
        String ring = new String("godding");
        System.out.println(ft.findRotateSteps(ring,"gd"));
        System.out.println(ft.findRotateSteps(ring,"gdg"));

    }
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];
        //dp[i][j] 表示key中第i个字条，ring中第j个字符在12点时，所需的最小步数。
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        //倒序，所以是dp[0][0]
        return dp[0][0] + m;
    }


//    Map<String, Map<Integer, Integer>> memo;
//    public int findRotateSteps(String ring, String key) {
//        memo = new HashMap<>();
//        return dfs(ring, key, 0);
//    }
//
//    private int findPos(String ring, char ch){ // find first occurrence clockwise
//        return ring.indexOf(ch);
//    }
//
//    private int findBackPos(String ring, char ch){ //find first occurrence  anti-clockwise
//        if(ring.charAt(0) == ch) return 0;
//        for(int i = ring.length()-1;i>0;i--){
//            if(ring.charAt(i) == ch) return i;
//        }
//        return 0;
//    }
//
//    private int dfs(String ring, String key, int i){
//        if(i == key.length()) return 0;
//        int res = 0;
//        char ch = key.charAt(i);
//        if(memo.containsKey(ring) && memo.get(ring).containsKey(i)) return memo.get(ring).get(i);
//        int f = findPos(ring, ch);
//        int b = findBackPos(ring, ch);
//        int forward = 1+f+dfs(ring.substring(f)+ring.substring(0, f), key, i+1);
//        int back = 1+ring.length()-b + dfs(ring.substring(b)+ring.substring(0, b),key, i+1);
//        res = Math.min(forward, back);
//        Map<Integer, Integer> ans = memo.getOrDefault(ring, new HashMap<>());
//        ans.put(i, res);
//        memo.put(ring, ans);
//        return res;
//    }
}
