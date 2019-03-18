package leetcode;

/**
 * Created by lyk on 2019-3-18.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SmallestStringStartingFromLeaf {
    String ans = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append((char)('a' + node.val));

        if (node.left == null && node.right == null) {
            sb.reverse();
            String S = sb.toString();
            sb.reverse();

            if (S.compareTo(ans) < 0)
                ans = S;
        }

        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        SmallestStringStartingFromLeaf sssfl = new SmallestStringStartingFromLeaf();
        TreeNode t1 = new TreeNode(0);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(sssfl.smallestFromLeaf(t1));
        TreeNode a1 = new TreeNode(25);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(3);
        TreeNode a6 = new TreeNode(0);
        TreeNode a7 = new TreeNode(2);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        System.out.println(sssfl.smallestFromLeaf(a1));
    }
}
