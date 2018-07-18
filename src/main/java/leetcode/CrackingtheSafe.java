package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-7-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CrackingtheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int total = (int) (Math.pow(k, n));
        for (int i = 0; i < n; i++) sb.append('0');
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        dfs(sb, total, visited, n, k);
        return sb.toString();
    }

    private boolean dfs(StringBuilder sb, int goal, Set<String> visited, int n, int k) {
        if (visited.size() == goal) return true;
        String prev = sb.substring(sb.length() - n + 1, sb.length());//the next n-1 digit
        for (int i = 0; i < k; i++) {
            String cur = prev + i;
            if (visited.contains(cur))
                continue;//确保每次添加，都形成了一次状态转移
            visited.add(cur);
            sb.append(i);
            if (dfs(sb, goal, visited, n, k))
                return true;//不停throw,找到第一个就返回
            else {
                visited.remove(cur);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
        return false;
    }


    public static void main(String[] args) {
        CrackingtheSafe cs = new CrackingtheSafe();
        System.out.println(cs.crackSafe(1, 2));
        System.out.println(cs.crackSafe(2, 3));
        System.out.println(cs.crackSafe(3, 3));
        System.out.println(cs.crackSafe(3, 4));
        System.out.println(cs.crackSafe(4, 4));
    }
}
