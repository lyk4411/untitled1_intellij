package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lyk on 2017/3/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PathSumII {
    public static void main(String[] args) {
        PathSumII psii = new PathSumII();
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
        System.out.println(psii.pathSum(a1,9));
        //System.out.println(psii.pathSum(a1,10));
        //System.out.println(psii.pathSum(a1,14));
        //System.out.println(psii.pathSum(a1,15));
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {
        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        //System.out.println("before:" + currentResult);
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            //System.out.println("AFTER:" + currentResult);

            return;
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
        //System.out.println("after:" + currentResult);
    }
}
