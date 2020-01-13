package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2020-1-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindElementsinaContaminatedBinaryTree {
    private Set<Integer> seen = new HashSet<>();

    public FindElementsinaContaminatedBinaryTree(TreeNode root) {
        dfs(root, 0);
    }
    private void dfs(TreeNode n, int v) {
        if (n == null) return;
        seen.add(v);
        n.val = v;
        dfs(n.left, 2 * v + 1);
        dfs(n.right, 2 * v + 2);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-1);
        TreeNode t2 = new TreeNode(-1);
        t1.right = t2;
        FindElementsinaContaminatedBinaryTree fecbt = new FindElementsinaContaminatedBinaryTree(t1);
        System.out.println(fecbt.find(1));
        System.out.println(fecbt.find(2));
    }
}
