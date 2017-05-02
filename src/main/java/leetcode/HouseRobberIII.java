package leetcode;

/**
 * Created by lyk on 2017/5/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        HouseRobberIII hriii = new HouseRobberIII();
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

        System.out.println(hriii.rob(a1));

    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
}
