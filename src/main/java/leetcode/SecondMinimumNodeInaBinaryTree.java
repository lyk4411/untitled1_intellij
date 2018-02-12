package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-2-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SecondMinimumNodeInaBinaryTree {
    public static void main(String[] args) {
        SecondMinimumNodeInaBinaryTree smnibt =
                new SecondMinimumNodeInaBinaryTree();
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        System.out.println(smnibt.findSecondMinimumValue(a1));

    }

    public void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.val);
            dfs(root.left, uniques);
            dfs(root.right, uniques);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        int min1 = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
