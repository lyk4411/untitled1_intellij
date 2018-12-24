package leetcode;

/**
 * Created by lyk on 2017/2/21.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {

        return (left != null ? left.toString() : " null ")
                + ":" + val + ":" +
                (right != null ? right.toString() : " null ");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            TreeNode t = (TreeNode) obj;
            return t.val == this.val;
        }
        return false;
    }
}
