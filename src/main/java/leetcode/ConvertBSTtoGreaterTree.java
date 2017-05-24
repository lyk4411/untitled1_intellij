package leetcode;

/**
 * Created by lyk on 2017/5/24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConvertBSTtoGreaterTree {
    public static void main(String[] args) {
        ConvertBSTtoGreaterTree cgt = new ConvertBSTtoGreaterTree();
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
        System.out.println(a1);
        System.out.println(cgt.ConvertBST(a1));
    }
    int sum = 0;
    public TreeNode ConvertBST(TreeNode root)
    {
        ConvertBST_helper(root);
        return root;
    }
    void ConvertBST_helper(TreeNode root)
    {
        if (root == null)
            return;

        ConvertBST_helper(root.right);
        sum += root.val;
        root.val = sum;
        ConvertBST(root.left);
    }
}
