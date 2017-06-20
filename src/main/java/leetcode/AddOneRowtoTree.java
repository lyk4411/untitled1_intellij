package leetcode;

/**
 * Created by lyk on 2017/6/20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AddOneRowtoTree {
    public static void main(String[] args) {
        AddOneRowtoTree aort = new AddOneRowtoTree();
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
        System.out.println(aort.addOneRow(a1,11,3));
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        add(root, v, d, 1);
        return root;
    }

    private void add(TreeNode node, int v, int d, int currentDepth) {
        if (node == null) {
            return;
        }

        if (currentDepth == d - 1) {
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
            return;
        }

        add(node.left, v, d, currentDepth + 1);
        add(node.right, v, d, currentDepth + 1);
    }
}
