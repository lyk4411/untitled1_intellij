package leetcode;

/**
 * Created by lyk on 2017/6/12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(3);
        TreeNode a7 = new TreeNode(4);
        TreeNode a8 = new TreeNode(4);
        TreeNode a9 = new TreeNode(5);

        a1.left = a2;
        a1.right = a3;
        a3.left = a4;
        a3.right = a5;
        a5.left = a6;
        a5.right = a7;
        a7.left = a8;
        a7.right = a9;

        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(1);
        TreeNode b3 = new TreeNode(2);
        TreeNode b4 = new TreeNode(2);
        TreeNode b5 = new TreeNode(3);
        TreeNode b6 = new TreeNode(3);
        TreeNode b7 = new TreeNode(4);
        TreeNode b8 = new TreeNode(4);
        TreeNode b9 = new TreeNode(5);

        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b3.left = b6;
        b3.right = b7;
        b4.left = b8;
        b4.right = b9;
        System.out.println(mtbt.mergeTrees(a1,b1));

    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);

        return newNode;
    }
}
