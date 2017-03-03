package leetcode;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PathSum {
    public  static  void main(String[] args) {
        PathSum ps = new PathSum();
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

        System.out.println(ps.hasPathSum(a1,11));
        System.out.println(ps.hasPathSum(a1,10));
        System.out.println(ps.hasPathSum(a1,9));
        System.out.println(ps.hasPathSum(a1,8));
        System.out.println(ps.hasPathSum(a1,7));
        System.out.println(ps.hasPathSum(a1,6));
        System.out.println(ps.hasPathSum(a1,5));


    }
        public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return  false;
        } else if(root.left == null && root.right == null  && root.val == sum){
            return true;
        } else {
            return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
        }
    }
}
