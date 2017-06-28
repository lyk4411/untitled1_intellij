package leetcode;

/**
 * Created by lyk on 2017/6/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CountofRangeSum {
    public static void main(String[] args) {
        CountofRangeSum crs = new CountofRangeSum();
        int[] nums1 = new int[]{-2,5,-1};

        System.out.println(crs.countRangeSum(nums1,-2,2));
    }

    //这题实际就是给定范围内的range sum，divide and conquer的方法。
    // 一路计算prefixSum[0:i]，并把结果放进tree里面，然后计算到prefixSum[0:j+1]
    // 的时候，找tree里面有没有满足条件的prefixSum[0:i]，这里的条件
    // 是lower <= sum[0:j+1] - sum[0:i] <= upper，那么
    // 可知sum[0:j+1] - upper <= sum[0:i] <= sum[0:j+1] - lower，那么
    // 这个就一个recursion就好了。注意一开始把0加进去，考虑结果是sum[0:j]的
    // 情况，还有要用long型，以免sum会overflow
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if(n == 0) return 0;
        // binary search tree
        Node root = new Node(0);
        int res = 0;
        long prefixSum = 0;
        for(int i = 0; i < n; i++) {
            prefixSum += nums[i];
            res += findNumInBound(root, lower, upper, prefixSum);
            insert(root, prefixSum);
        }
        return res;
    }

    private int findNumInBound(Node node, long low, long up, long sum) {
        // base case
        if(node == null) return 0;
        // range: sum - up <= node.val <= sum - low
        if(node.val < sum - up) return findNumInBound(node.right, low, up, sum);
        else if(node.val > sum - low) return findNumInBound(node.left, low, up, sum);
        else return 1 + findNumInBound(node.left, low, up, sum) + findNumInBound(node.right, low, up, sum);
    }

    private void insert(Node node, long value) {
        while(node != null) {
            if(node.val > value) {
                if(node.left == null) {
                    node.left = new Node(value);
                    break;
                }
                node = node.left;
            }
            else {
                if(node.right == null) {
                    node.right = new Node(value);
                    break;
                }
                node = node.right;
            }
        }
    }
    class Node {
        long val;
        Node left;
        Node right;
        Node(long val) { this.val = val; }
    }
}