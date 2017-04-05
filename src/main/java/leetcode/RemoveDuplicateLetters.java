package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lyk on 2017/4/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
        String s1 = new String("abcdfadfeadfdadadf");
        System.out.println(rdl.removeDuplicateLetters(s1));
    }
    public String removeDuplicateLetters(String s) {
        int[] freqs = new int[256];

        // 统计字符频率
        for (int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i)]++;
        }

        boolean[] visited = new boolean[256]; // 用来标记存在stack里的字符
        Deque<Character> q = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqs[c]--;
            if (visited[c]) continue;

            // pop出stack当中比当前字符大但后面还存在的的字符，
            while (!q.isEmpty() && q.peek() > c && freqs[q.peek()] > 0) {
                visited[q.pop()] = false;
            }
            q.push(c);
            visited[c] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : q) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
