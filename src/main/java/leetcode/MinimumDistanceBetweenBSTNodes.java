package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-4-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        vis = new ArrayList<Integer>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < vis.size(); ++i) {
            int diff = vis.get(i) - vis.get(i - 1);
            min = Math.min(min, diff);
        }
        return min;
    }

    List<Integer> vis;

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        vis.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        MinimumDistanceBetweenBSTNodes mdbbn =
                new MinimumDistanceBetweenBSTNodes();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(mdbbn.minDiffInBST(t1));
    }
}
