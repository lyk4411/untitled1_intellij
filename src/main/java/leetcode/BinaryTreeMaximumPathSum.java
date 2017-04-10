package leetcode;

/**
 * Created by lyk on 2017/4/10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum btmps = new BinaryTreeMaximumPathSum();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(2);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(30);
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
        System.out.println(btmps.maxPathSum(a1));
    }
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        calculateSum(root, max);
        return max[0];
    }
    public int calculateSum(TreeNode root, int[] max) {
        if (root == null)
            return 0;
        int left  = Math.max(0,calculateSum(root.left,max));
        int right = Math.max(0,calculateSum(root.right,max));
        //最终结果的最大值；每个节点的最大值；
        max[0] = Math.max(max[0],left + right + root.val);

        //路径的最大值（最大值不一定经过根节点）
        return Math.max(left,right) + root.val;
    }
//    public int calculateSum(TreeNode root, int[] max) {
//        if (root == null)
//            return 0;
//
//        int left = calculateSum(root.left, max);
//        int right = calculateSum(root.right, max);
//
//        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
//
//        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
//
//        return current;
//    }
}
