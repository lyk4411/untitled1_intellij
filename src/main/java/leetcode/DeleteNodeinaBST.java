package leetcode;

/**
 * Created by lyk on 2017/6/5.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class DeleteNodeinaBST {
    public static void main(String[] args) {
        DeleteNodeinaBST dnbst = new DeleteNodeinaBST();
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(6);
        TreeNode a4 = new TreeNode(2);
        TreeNode a5 = new TreeNode(4);
        TreeNode a6 = new TreeNode(7);
        TreeNode a7 = new TreeNode(1);
        TreeNode a8 = new TreeNode(8);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.right = a6;
        a4.left = a7;
        a6.right = a8;
        System.out.println(a1);
        System.out.println(dnbst.deleteNode(a1,6));
    }

//    private TreeNode deleteRootNode(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        if (root.left == null) {
//            return root.right;
//        }
//        if (root.right == null) {
//            return root.left;
//        }
//        TreeNode next = root.right;
//        TreeNode pre = null;
//        for(; next.left != null; pre = next, next = next.left);
//        next.left = root.left;
//        //if(root.right != next) {
//        if(pre != null)  {
//            pre.left = next.right;
//            next.right = root.right;
//        }
//        return next;
//    }
//
//    public TreeNode deleteNode(TreeNode root, int key) {
//        TreeNode cur = root;
//        TreeNode pre = null;
//        while(cur != null && cur.val != key) {
//            pre = cur;
//            if (key < cur.val) {
//                cur = cur.left;
//            } else if (key > cur.val) {
//                cur = cur.right;
//            }
//        }
//        if (pre == null) {
//            return deleteRootNode(cur);
//        }
//        if (pre.left == cur) {
//            pre.left = deleteRootNode(cur);
//        } else {
//            pre.right = deleteRootNode(cur);
//        }
//        return root;
//    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
