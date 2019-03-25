package leetcode;

/**
 * Created by lyk on 2019-3-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DistributeCoinsinBinaryTree {
//    If the leaf of a tree has 0 coins (an excess of -1 from what it needs), then we should
// push a coin from its parent onto the leaf. If it has say, 4 coins (an excess of 3), then
// we should push 3 coins off the leaf. In total, the number of moves from that leaf to or
// from its parent is excess = Math.abs(num_coins - 1). Afterwards, we never have to consider
// this leaf again in the rest of our calculation.
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
