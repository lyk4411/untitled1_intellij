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

        return (left!=null?left.toString():"")
                + ":" + val + ":" +
                (right !=null?right.toString():"");
    }
}
