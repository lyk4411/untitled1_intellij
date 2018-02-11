package leetcode;

/**
 * Created by lyk on 2018-2-11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TrimaBinarySearchTree {
    public static void main(String[] args) {
        TrimaBinarySearchTree tbst = new TrimaBinarySearchTree();
        TreeNode a1 = new TreeNode(1);
        TreeNode a0 = new TreeNode(0);
        TreeNode a2 = new TreeNode(2);
        a1.left = a0;
        a1.right = a2;

        TreeNode b0 = new TreeNode(0);
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(2);
        TreeNode b3 = new TreeNode(3);
        TreeNode b4 = new TreeNode(4);
        b3.left = b0;
        b0.right = b2;
        b2.left = b1;
        b3.right = b4;
        System.out.println(a1);
        System.out.println(b3);
        System.out.println("============================================");
        tbst.trimBST(a1,1,2);
        tbst.trimBST(b3,1,3);
        System.out.println(a1);
        System.out.println(b3);

    }
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }


}


