package leetcode;

import java.util.LinkedList;

/**
 * Created by lyk on 2017/3/7.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        MinimumDepthofBinaryTree mdbt = new MinimumDepthofBinaryTree();
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

//        System.out.println(mdbt.minDepth(a1));
//        System.out.println(mdbt.minDepth(a2));
//        System.out.println(mdbt.minDepth(a3));

        System.out.println(mdbt.minDepth1(a1));
        System.out.println(mdbt.minDepth1(a2));
        System.out.println(mdbt.minDepth1(a3));

        System.out.println(mdbt.minDepth2(a1));
        System.out.println(mdbt.minDepth2(a2));
        System.out.println(mdbt.minDepth2(a3));

    }
    public int minDepth2(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth2(root.left);
        int right = minDepth2(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth1(root.right)+1;
        if(root.right == null)
            return minDepth1(root.left)+1;
        return Math.min(minDepth1(root.left),minDepth1(root.right))+1;
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();

        nodes.add(root);
        counts.add(1);

        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();

            if(curr.left == null && curr.right == null){
                return count;
            }

            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }

            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
        }

        return 0;
    }
}
