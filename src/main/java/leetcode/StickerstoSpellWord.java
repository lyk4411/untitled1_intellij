package leetcode;

/**
 * Created by lyk on 2018-7-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class StickerstoSpellWord {
//    private HashMap<String, Integer> dmap;
//    private HashMap<String, int[]> scnts;
//
//    public int[] str2Cnt(String str) {
//        int[] cnt = new int[26];
//        for (int i = 0; i < str.length(); i++) {
//            cnt[str.charAt(i) - 'a']++;
//        }
//        return cnt;
//    }
//
//    public String cnt2Str(int[] cnt) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < 26; i++) {
//            for (int j = 0; j < cnt[i]; j++) {
//                sb.append('a' + i);
//            }
//        }
//        return sb.toString();
//    }
//
//    public int minStickers(String[] stickers, String target) {
//        dmap = new HashMap<>();
//        scnts = new HashMap<>();
//        int[] tcnt = str2Cnt(target);
//        for (int i = 0; i < stickers.length; i++) {
//            StringBuffer sb = new StringBuffer();
//            for (int j = 0; j < stickers[i].length(); j++) {
//                char ch = stickers[i].charAt(j);
//                if (tcnt[ch - 'a'] > 0) sb.append(ch);
//            }
//            String str = sb.toString();
//            if (str.length() > 0 && !scnts.containsKey(str)) {
//                scnts.put(str, str2Cnt(str));
//            }
////            System.out.println(scnts);
//        }
//        return search(tcnt);
//    }
//
//    public int search(int[] kcnt) {
//        String key = cnt2Str(kcnt);
//        if (key.length() == 0) {
//            return 0;
//        }
////        if (scnts.keySet().contains(key)) {
////            return 1;
////        }
//        if (dmap.containsKey(key)) {
//            return dmap.get(key);
//        }
//        int ans = -1;
//        for (int[] scnt : scnts.values()) {
//            int[] nkcnt = kcnt.clone();
//            boolean stopFlag = true;
//            for (int i = 0; i < 26; i++) {
//                int nval = Math.max(0, nkcnt[i] - scnt[i]);
//                if (nval != nkcnt[i]) stopFlag = false;
//                nkcnt[i] = nval;
//            }
//            if (stopFlag) continue;
//            int val = search(nkcnt);
//            if (val < 0) continue;
//            if (ans < 0 || val + 1 < ans) ans = val + 1;
//        }
//        dmap.put(key, ans);
//        return ans;
//    }
    public int minStickers(String[] stickers, String target) {
        int N = target.length();
        int[] dp = new int[1 << N];
        for (int i = 1; i < 1 << N; i++) dp[i] = -1;

        for (int state = 0; state < 1 << N; state++) {
            if (dp[state] == -1) continue;
            for (String sticker: stickers) {
                int now = state;
                for (char letter: sticker.toCharArray()) {
                    for (int i = 0; i < N; i++) {
                        if (((now >> i) & 1) == 1) continue;
                        if (target.charAt(i) == letter) {
                            now |= 1 << i;
                            break;
                        }
                    }
                }
                if (dp[now] == -1 || dp[now] > dp[state] + 1) {
                    dp[now] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << N) - 1];
    }

    public static void main(String[] args) {
        StickerstoSpellWord ssw = new StickerstoSpellWord();
        String[] stickers1 = new String[]{
                "with", "eexaample", "science"
        };
        String[] stickers2 = new String[]{
                "notice", "possible","ss","s"
        };

        System.out.println(ssw.minStickers(stickers1, "thehat"));
        System.out.println(ssw.minStickers(stickers2, "basicbasic"));

    }

}
