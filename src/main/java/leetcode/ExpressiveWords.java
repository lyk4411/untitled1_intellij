package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2019-7-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        RLE R = new RLE(S);
//        System.out.println(R.key);
//        System.out.println(R.counts);
        int ans = 0;

        search: for (String word: words) {
            RLE R2 = new RLE(word);
            if (!R.key.equals(R2.key)) continue;
            for (int i = 0; i < R.counts.size(); ++i) {
                int c1 = R.counts.get(i);
                int c2 = R2.counts.get(i);
                if (c1 < 3 && c1 != c2 || c1 < c2)
                    continue search;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        ExpressiveWords ew = new ExpressiveWords();
        String S = new String("heeellooo");
        String[] words = new String[]{
                "hello", "hi", "helo"
        };
        System.out.println(ew.expressiveWords(S, words));
    }
}

class RLE {
    String key;
    List<Integer> counts;

    public RLE(String S) {
        StringBuilder sb = new StringBuilder();
        counts = new ArrayList();

        char[] ca = S.toCharArray();
        int N = ca.length;
        int prev = -1;
        for (int i = 0; i < N; ++i) {
            if (i == N-1 || ca[i] != ca[i+1]) {
                sb.append(ca[i]);
                counts.add(i - prev);
                prev = i;
            }
        }

        key = sb.toString();
    }
}
