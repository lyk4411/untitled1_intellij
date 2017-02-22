package leetcode;

/**
 * Created by lyk on 2017/2/21.
 * Package name: leetcode
 * Project name: untitled1
 */
public class FindModeInBinarySearchTree {
    public  static  void main(String[] args){
        FindModeInBinarySearchTree fm = new FindModeInBinarySearchTree();
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
        int[] results = fm.findMode(a1);
        for(int result:results) {
            System.out.println(String.valueOf(result));
        }
    }

    private int max = 0;//最多几个相同值
    private int currval = 0;//现在的值
    private int currcount = 0;//现在的值的个数
    private int currmodes = 0;//现在有几个值出现个数最多
    private int[] modes;

    public int[] findMode(TreeNode root) {
        helper(root);
        modes = new int[currmodes];
        currcount = 0;
        currmodes = 0;
        helper(root);
        return modes;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (root.val != currval) {
            currval = root.val;
            currcount = 1;
        } else {
            currcount ++;
        }
        if (currcount > max) {
            max = currcount;
            currmodes = 1;
        }else if (currcount == max) {
            if (modes != null) {
                modes[currmodes] = root.val;
            }
            currmodes ++;
        }
        helper(root.right);
    }
}
