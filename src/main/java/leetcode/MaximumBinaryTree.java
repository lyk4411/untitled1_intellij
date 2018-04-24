package leetcode;

/**
 * Created by lyk on 2018-4-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r)
            return null;
        int max_i = max(nums, l, r);
        TreeNode root = new TreeNode(nums[max_i]);
        root.left = construct(nums, l, max_i);
        root.right = construct(nums, max_i + 1, r);
        return root;
    }
    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }

    public static void main(String[] args) {
        MaximumBinaryTree mbt = new MaximumBinaryTree();
        int[] nums = new int[]{3,2,1,6,0,5};
        System.out.println(mbt.constructMaximumBinaryTree(nums));
    }
}
