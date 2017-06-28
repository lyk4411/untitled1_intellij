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