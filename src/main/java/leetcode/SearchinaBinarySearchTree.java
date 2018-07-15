package leetcode;

/**
 * Created by lyk on 2018-7-15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

    public static void main(String[] args) {
        SearchinaBinarySearchTree sbst = new SearchinaBinarySearchTree();
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        System.out.println(sbst.searchBST(t1, 2));
        System.out.println(sbst.searchBST(t1, 5));
    }
}
