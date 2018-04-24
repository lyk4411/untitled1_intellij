package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lyk on 2018-4-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for(String[] arr:res)
            Arrays.fill(arr,"");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        if (root == null)
            return;
        res[i][(l + r) / 2] = "" + root.val;
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        PrintBinaryTree pbt = new PrintBinaryTree();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.left = t2;
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        a1.left = a2;
        a1.right = a3;
        a2.right = a4;
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(5);
        TreeNode b4 = new TreeNode(3);
        TreeNode b5 = new TreeNode(4);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b4.left = b5;

        System.out.println(pbt.printTree(t1));
        System.out.println(pbt.printTree(a1));
        System.out.println(pbt.printTree(b1));

    }
}
