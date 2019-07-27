package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by lyk on 2019-7-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SatisfiabilityofEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        ArrayList<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            graph[i] = new ArrayList();

        for (String eqn: equations) {
            if (eqn.charAt(1) == '=') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                graph[x].add(y);
                graph[y].add(x);
            }
        }

        int[] color = new int[26];
        int t = 0;
        for (int start = 0; start < 26; ++start) {
            if (color[start] == 0) {
                t++;
                Stack<Integer> stack = new Stack();
                stack.push(start);
                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int nei: graph[node]) {
                        if (color[nei] == 0) {
                            color[nei] = t;
                            stack.push(nei);
                        }
                    }
                }
            }
        }

        for (String eqn: equations) {
            if (eqn.charAt(1) == '!') {
                int x = eqn.charAt(0) - 'a';
                int y = eqn.charAt(3) - 'a';
                if (x == y || color[x] != 0 && color[x] == color[y])
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SatisfiabilityofEqualityEquations see = new SatisfiabilityofEqualityEquations();
        String[] s1 = new String[]{"a==b", "b!=a"};
        String[] s2 = new String[]{"b==a", "a==b"};
        String[] s3 = new String[]{"a==b", "b==c", "a==c"};
        String[] s4 = new String[]{"a==b", "b!=c", "c==a"};
        String[] s5 = new String[]{"c==c", "b==d", "x!=z"};

        System.out.println(see.equationsPossible(s1));
        System.out.println(see.equationsPossible(s2));
        System.out.println(see.equationsPossible(s3));
        System.out.println(see.equationsPossible(s4));
        System.out.println(see.equationsPossible(s5));
    }
}
