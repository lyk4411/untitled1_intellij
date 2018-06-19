package leetcode;

/**
 * Created by lyk on 2018-6-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    public static void main(String[] args) {
        BinaryTreePruning btp = new BinaryTreePruning();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(1);
        t1.right = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(t1);
        System.out.println(btp.pruneTree(t1));

    }
}
