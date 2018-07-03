package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2018-7-3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int diff_cnt = 0;
        int idxs[] = new int[20005];
        for (int i = 0; i < A.length(); ++i) {
            if (!A.substring(i, i + 1).equals(B.substring(i, i + 1))) {
                idxs[diff_cnt++] = i;
            }
        }
        if (diff_cnt == 0) {
            // 没有不同
            // 看A里是否有相同的字符串
            char[] arr = A.toCharArray();
            Map<Character, Boolean> m = new HashMap<>();
            for (char a : arr) {
                if (m.containsKey(a)) {
                    return true;
                } else {
                    m.put(a,true);
                }
            }
            return false;
        }
        if (diff_cnt != 2) {
            return false;
        }
        char[] arr = A.toCharArray();
        char temp = arr[idxs[0]];
        arr[idxs[0]] = arr[idxs[1]];
        arr[idxs[1]] = temp;
        A = String.valueOf(arr);
        return A.equals(B);
    }

    public static void main(String[] args) {
        BuddyStrings bs = new BuddyStrings();
        System.out.println(bs.buddyStrings("aaa","bba"));
        System.out.println(bs.buddyStrings("abb","bba"));
    }
}
