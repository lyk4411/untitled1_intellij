package leetcode;

import java.util.Arrays;

/**
 * Created by lyk on 2017/3/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AssignCookies {
    public static void main(String[] args) {
        AssignCookies ac = new AssignCookies();
        int[] g = new int[]{1,1,3,1,2,3};
        int[] s = new int[]{1,3};
        System.out.println(ac.findContentChildren(g,s));
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for(int j=0;i<g.length && j<s.length;j++) {
            if(g[i]<=s[j]) i++;
        }
        return i;
    }
}
