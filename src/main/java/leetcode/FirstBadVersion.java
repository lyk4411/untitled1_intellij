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
        int low=1, high=n;

        while(low<high) {
            int mid=low + (high-low)/2;
            if(isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;

                System.out.println("mid:"+ mid);
                System.out.println("low:"+ low);
            }
        }
        return low;
    }

    private boolean isBadVersion(int mid) {
        if(mid >= 10){
            return true;
        } else {
            return false;
        }
    }
}
