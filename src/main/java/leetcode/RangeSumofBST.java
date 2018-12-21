package leetcode;

/**
 * Created by lyk on 2018-12-21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RangeSumofBST {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans = 0;
        dfs(root, L, R);
        return ans;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                ans += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }

    public static void main(String[] args) {
        RangeSumofBST rsbst = new RangeSumofBST();
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        System.out.println(rsbst.rangeSumBST(t1, 7, 15));

    }
}
