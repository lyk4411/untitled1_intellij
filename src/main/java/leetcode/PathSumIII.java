package leetcode;

/**
 * Created by lyk on 2017/3/9.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII psiii = new PathSumIII();
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
        System.out.println(psiii.pathSum(a1,5));
    }
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }

    private int dfs(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res+=dfs(root.left,sum - root.val);
        res+=dfs(root.right,sum - root.val);
        return res;
    }
}
