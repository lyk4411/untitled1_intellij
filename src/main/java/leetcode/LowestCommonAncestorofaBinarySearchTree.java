package leetcode;

/**
 * Created by lyk on 2017/3/31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args) {
        LowestCommonAncestorofaBinarySearchTree lcabst = new LowestCommonAncestorofaBinarySearchTree();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);

        a5.left = a3;
        a5.right = a8;
        a3.left = a2;
        a3.right = a4;
        a2.left = a1;
        a8.left = a6;
        a8.right = a9;
        a6.right = a7;
        System.out.println(lcabst.lowestCommonAncestor(a5,a7,a9));
        System.out.println(lcabst.lowestCommonAncestor(a5,a2,a4));
        System.out.println(lcabst.lowestCommonAncestor(a5,a7,a1));
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}
