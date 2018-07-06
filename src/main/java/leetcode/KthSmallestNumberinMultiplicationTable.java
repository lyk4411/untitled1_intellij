package leetcode;

/**
 * Created by lyk on 2018-7-6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class KthSmallestNumberinMultiplicationTable {

//    为了快速定位出第K小的数字，我们采用二分搜索法，由于是有序矩阵，那么左上角的数字一定是最小的，
//    而右下角的数字一定是最大的，所以这个是我们搜索的范围，然后我们算出中间数字mid，由于矩阵中不
//    同行之间的元素并不是严格有序的，所以我们要在每一行都查找一下mid，由于乘法表每行都是连续数
//    字1，2，3...乘以当前行号（从1开始计数），所以我们甚至不需要在每行中使用二分查找，而是直接定
//    位出位置。具体做法是，先比较mid和该行最后一个数字的大小，最后一数字是n * i，i是行数，n是该行
//    数字的个数，如果mid大的话，直接将该行所有数字的个数加入cnt，否则的话加上mid / i，比如当前行
//    是2, 4, 6, 8, 10，如果我们要查找小于7的个数，那么就是7除以2，得3，就是有三个数小于7，直接加
//    入cnt即可。这样我们就可以快速算出矩阵中所有小于mid的个数，根据cnt和k的大小关系，来更新我们的
//    范围，循环推出后，left就是第K小的数字，参见代码如下：

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while (left < right){
            int mid = left + (right - left) / 2, cnt = 0;
            for(int i = 1; i <= m; i++){
                cnt += (mid > n * i) ? n : (mid / i);
            }
            if(cnt < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        KthSmallestNumberinMultiplicationTable ksnmt = new KthSmallestNumberinMultiplicationTable();
        System.out.println(ksnmt.findKthNumber(3, 3, 5));
        System.out.println(ksnmt.findKthNumber(2, 3, 6));
    }
}
