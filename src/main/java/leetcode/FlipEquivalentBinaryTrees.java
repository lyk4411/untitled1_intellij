package leetcode;

/**
 * Created by lyk on 2018-12-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FlipEquivalentBinaryTrees {
//    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
//        List<Integer> vals1 = new ArrayList();
//        List<Integer> vals2 = new ArrayList();
//        dfs(root1, vals1);
//        dfs(root2, vals2);
//        return vals1.equals(vals2);
//    }
//
//    public void dfs(TreeNode node, List<Integer> vals) {
//        if (node != null) {
//            vals.add(node.val);
//            int L = node.left != null ? node.left.val : -1;
//            int R = node.right != null ? node.right.val : -1;
//
//            if (L < R) {
//                dfs(node.left, vals);
//                dfs(node.right, vals);
//            } else {
//                dfs(node.right, vals);
//                dfs(node.left, vals);
//            }
//        }
//    }
//}
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }


    public static void main(String[] args) {
        FlipEquivalentBinaryTrees febt = new FlipEquivalentBinaryTrees();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.right = a2;
        a1.left = a3;
        System.out.println(febt.flipEquiv(t1, a1));

//        System.out.println(t2.equals(a2));
//        System.out.println(t2 == a2);
//        System.out.println(t2.left == a2.left);
//        System.out.println(null == null);

    }
}
