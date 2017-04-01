package leetcode;

/**
 * Created by lyk on 2017/4/1.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,7,8,9,0,1,2,3};
        RangeSumQuery rsq = new RangeSumQuery(nums);
        System.out.println(rsq.sumRange(0,11));
    }
        SegmentTreeNode root = null;

        public RangeSumQuery(int[] nums) {
            if(nums==null || nums.length==0)
                return;

            this.root = buildTree(nums, 0, nums.length-1);
        }

        void update(int i, int val) {
            updateHelper(root, i, val);
        }

        void updateHelper(SegmentTreeNode root, int i, int val){
            if(root==null)
                return;

            int mid = root.start + (root.end-root.start)/2;
            if(i<=mid){
                updateHelper(root.leftChild, i, val);
            }else{
                updateHelper(root.rightChild, i, val);
            }

            if(root.start==root.end&& root.start==i){
                root.sum=val;
                return;
            }

            root.sum=root.leftChild.sum+root.rightChild.sum;
        }

        public int sumRange(int i, int j) {
            return sumRangeHelper(root, i, j);
        }

        public int sumRangeHelper(SegmentTreeNode root, int i, int j){
            if(root==null || j<root.start || i > root.end ||i>j )
                return 0;

            if(i<=root.start && j>=root.end){
                return root.sum;
            }
            int mid = root.start + (root.end-root.start)/2;
            int result = sumRangeHelper(root.leftChild, i, Math.min(mid, j))
                    +sumRangeHelper(root.rightChild, Math.max(mid+1, i), j);

            return result;
        }

        public SegmentTreeNode buildTree(int[] nums, int i, int j){
            if(nums==null || nums.length==0|| i>j)
                return null;

            if(i==j){
                return new SegmentTreeNode(i, j, nums[i]);
            }

            SegmentTreeNode current = new SegmentTreeNode(i, j);

            int mid = i + (j-i)/2;

            current.leftChild = buildTree(nums, i, mid);
            current.rightChild = buildTree(nums, mid+1, j);

            current.sum = current.leftChild.sum+current.rightChild.sum;

            return current;
        }
}

class SegmentTreeNode{
    int start;
    int end;
    int sum;
    SegmentTreeNode leftChild;
    SegmentTreeNode rightChild;

    public SegmentTreeNode(int left, int right, int sum){
        this.start=left;
        this.end=right;
        this.sum=sum;
    }
    public SegmentTreeNode(int left, int right){
        this.start=left;
        this.end=right;
        this.sum=0;
    }
}
