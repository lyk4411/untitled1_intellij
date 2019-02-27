package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyk on 2019-2-27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CousinsinBinaryTree {
    Map<Integer, Integer> depth;
    Map<Integer, TreeNode> parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth = new HashMap();
        parent = new HashMap();
        dfs(root, null);
        return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
            parent.put(node.val, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        CousinsinBinaryTree cbt = new CousinsinBinaryTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        System.out.println(cbt.isCousins(t1, 2, 3));
        System.out.println(cbt.isCousins(t1, 4, 5));

    }
}
