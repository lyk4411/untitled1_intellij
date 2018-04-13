package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lyk on 2018-4-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    public static void main(String[] args) {
        TwoSumIV tsiv = new TwoSumIV();
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(7);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;
        System.out.println(tsiv.findTarget(a1,9));
        System.out.println(tsiv.findTarget(a1,28));
    }
}
