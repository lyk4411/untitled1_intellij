package leetcode;

import java.util.LinkedList;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumDepthofBinaryTree {
    public  static  void main(String[] args) {
        MaximumDepthofBinaryTree mdbt = new MaximumDepthofBinaryTree();
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

        System.out.println("a1:" + mdbt.maxDepth(a1));
        System.out.println("a4:" + mdbt.maxDepth(a4));


    }
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
        while(!queue.isEmpty())
        {
            TreeNode n = queue.poll();
            curNum--;
            if(n.left!=null)
            {
                queue.add(n.left);
                nextNum++;
            }
            if(n.right!=null)
            {
                queue.add(n.right);
                nextNum++;
            }
            if(curNum == 0)
            {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }
}
