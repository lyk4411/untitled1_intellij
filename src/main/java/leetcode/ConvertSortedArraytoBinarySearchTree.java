package leetcode;

import java.util.concurrent.Callable;

/**
 * Created by lyk on 2017/3/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConvertSortedArraytoBinarySearchTree {
    public  static  void main(String[] args) {
        ConvertSortedArraytoBinarySearchTree csabst = new ConvertSortedArraytoBinarySearchTree();
        int[] a = new int[]{1,2,3,4,5,6,7,7,7,7,8,9};
        TreeNode tn = csabst.sortedArrayToBST(a);
        System.out.println(tn);
        Callable<Object> callable = new Callable<Object>() {
            public Object call() throws Exception {

                return null;
            }
        };
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }
}
