package leetcode;

/**
 * Created by lyk on 2017/2/23.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FirstBadVersion {
    public static  void main(String[] args){
        FirstBadVersion fbv = new FirstBadVersion();
        System.out.println("result:" + fbv.firstBadVersion(100));
        //System.out.println("result:" + fbv.firstBadVersion(1000));

    }
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }
        return start;
    }

    private boolean isBadVersion(int mid) {
        if(mid >= 10){
            return true;
        } else {
            return false;
        }
    }
}
