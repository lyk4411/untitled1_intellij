package leetcode;

/**
 * Created by lyk on 2019-3-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DistributeCoinsinBinaryTree {
    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }

    public static void main(String[] args) {
        DistributeCoinsinBinaryTree dcbt = new DistributeCoinsinBinaryTree();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(0);
        t1.left = t2;
        t1.right = t3;
        System.out.println(dcbt.distributeCoins(t1));
    }
}
