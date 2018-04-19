package leetcode;

/**
 * Created by lyk on 2018-4-19.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LongestUnivaluePath {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
//    这道题让我们求最长的相同值路径，跟之前那道Count Univalue Subtrees十分的类似，
//    解法也很类似。对于这种树的路径问题，递归是不二之选。在递归函数中，我们首先
//    对其左右子结点调用递归函数，得到其左右子树的最大相同值路径，下面就要来看当前
//    结点和其左右子结点之间的关系了，如果其左子结点存在且和当前节点值相同，则left
//    自增1，否则left重置0；同理，如果其右子结点存在且和当前节点值相同，则right自
//    增1，否则right重置0。然后用left+right来更新结果res。而调用当前节点值的函数只
//    能返回left和right中的较大值，因为如果还要跟父节点组path，就只能在左右子节点
//    中选一条path，当然选值大的那个了，参见代码如下：
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        LongestUnivaluePath lup = new LongestUnivaluePath();
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        System.out.println(lup.longestUnivaluePath(t1));
    }
}
