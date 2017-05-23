package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lyk on 2017/5/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FindLargestValueinEachTreeRow {
    public static void main(String[] args) {
        FindLargestValueinEachTreeRow flvet = new FindLargestValueinEachTreeRow();
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
        System.out.println(flvet.largestValues(a1));
    }
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        helper(root, res, 0);
//        return res;
//    }
//    private void helper(TreeNode root, List<Integer> res, int d){
//        if(root == null){
//            return;
//        }
//        //expand list size
//        if(d == res.size()){
//            res.add(root.val);
//        }
//        else{
//            //or set value
//            res.set(d, Math.max(res.get(d), root.val));
//        }
//        helper(root.left, res, d+1);
//        helper(root.right, res, d+1);
//    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(max);
        }

        return res;
    }
}
