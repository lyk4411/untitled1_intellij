package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII btlotiii = new BinaryTreeLevelOrderTraversalII();
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
        List<List<Integer>> lli =btlotiii.levelOrderBottom(a1);
        //System.out.println(lli);
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        addLevel(list, 0, root);
        return list;
    }

    private void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
        if (node == null) {
            System.out.println(list);
            return;
        }
        if (list.size()-1 < level) {
            list.addFirst(new LinkedList<Integer>());
        }
        list.get(list.size()-1-level).add(node.val);
        System.out.println(list);
        addLevel(list, level+1, node.left);
        addLevel(list, level+1, node.right);
    }
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result = new  ArrayList<List<Integer>>();
//
//        if(root == null){
//            return result;
//        }
//
//        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
//        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
//        current.offer(root);
//
//        ArrayList<Integer> numberList = new ArrayList<Integer>();
//
//        // need to track when each level starts
//        while(!current.isEmpty()){
//            TreeNode head = current.poll();
//
//            numberList.add(head.val);
//
//            if(head.left != null){
//                next.offer(head.left);
//            }
//            if(head.right!= null){
//                next.offer(head.right);
//            }
//
//            if(current.isEmpty()){
//                current = next;
//                next = new LinkedList<TreeNode>();
//                result.add(numberList);
//                numberList = new ArrayList<Integer>();
//            }
//        }
//
//        //return Collections.reverse(result);
//        List<List<Integer>> reversedResult = new  ArrayList<List<Integer>>();
//        for(int i=result.size()-1; i>=0; i--){
//            reversedResult.add(result.get(i));
//        }
//
//        return reversedResult;
//    }
}
