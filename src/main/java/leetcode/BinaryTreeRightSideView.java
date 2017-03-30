package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/30.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        BinaryTreeRightSideView btrsv = new BinaryTreeRightSideView();
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
        System.out.println(btrsv.rightSideView(a1));
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.val);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }

        return result;
    }

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        rightView(root, result, 0);
//        return result;
//    }
//    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
//        if(curr == null){
//            return;
//        }
//        if(currDepth == result.size()){
//            result.add(curr.val);
//        }
//
//        rightView(curr.right, result, currDepth + 1);
//        rightView(curr.left, result, currDepth + 1);
//
//    }
}
