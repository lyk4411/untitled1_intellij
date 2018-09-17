package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2018-9-17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = cur = new TreeNode(v);
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    public static void main(String[] args) {
        IncreasingOrderSearchTree iost = new IncreasingOrderSearchTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t4.left = t2;
        t4.right = t5;
        t2.left = t1;
        t2.right = t3;
        t5.right = t6;
        System.out.println(t4);
        System.out.println(iost.increasingBST(t4));
    }
}
