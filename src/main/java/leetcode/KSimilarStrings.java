package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-7-23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KSimilarStrings {
    Map<String,Integer> memo = new HashMap<>();

    public int kSimilarity(String A, String B) {
        return solve(A, B);
    }

    private int solve(String a, String b) {
        StringBuilder a1 = new StringBuilder();
        StringBuilder b1 = new StringBuilder();
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                a1.append(a.charAt(i));
                b1.append(b.charAt(i));
            }
        }
        if(a1.length() == 0){
            return 0;
        }
        if (memo.containsKey(a1.toString() + "#" + b1.toString())){
            memo.get(a1.toString() + "#" + b1.toString());
        }
        int ans = 9999999;
        for (int i = 0; i < a1.length(); i++){
            if(a1.charAt(i) == b1.charAt(0)){
                String c = "";
                if(i != a1.length() - 1){
                    c = a1.substring(1,i) + a1.charAt(0) + a1.substring(i + 1);
                }else {
                    c = a1.substring(1,i) + a1.charAt(0);
                }
                ans = Math.min(ans, solve(c, b1.substring(1)));
            }
        }
        memo.putIfAbsent(a1 + "#" + b1, ans + 1);
        return ans + 1;
    }

    public static void main(String[] args) {
        KSimilarStrings kss = new KSimilarStrings();
        System.out.println(kss.kSimilarity("ab","ba"));
        System.out.println(kss.kSimilarity("aabc","abca"));
        System.out.println(kss.kSimilarity("abcdefg","bagfedc"));

    }

}
