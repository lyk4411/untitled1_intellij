package leetcode;

/**
 * Created by lyk on 2017/5/25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        CountCompleteTreeNodes cctn = new CountCompleteTreeNodes();
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
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        a4.left = a8;
        a4.right = a9;
        System.out.println(cctn.countNodes(a1));
    }
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;

        int left = getLeftHeight(root)+1;
        int right = getRightHeight(root)+1;

        if(left==right){
            return (1<<left)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }

    public int getLeftHeight(TreeNode n){
        if(n==null) return 0;

        int height=0;
        while(n.left!=null){
            height++;
            n = n.left;
        }
        return height;
    }

    public int getRightHeight(TreeNode n){
        if(n==null) return 0;

        int height=0;
        while(n.right!=null){
            height++;
            n = n.right;
        }
        return height;
    }
//    public int countNodes(TreeNode root) {
//        if (root == null)
//            return 0;
//        TreeNode left = root, right = root;
//        int height = 0;
//        while (right != null) {
//            left = left.left;
//            right = right.right;
//            height++;
//        }
//        if (left == null)
//            return (1 << height) - 1;
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
}
