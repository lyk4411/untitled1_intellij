package leetcode;

/**
 * Created by lyk on 2017/3/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Sqrt {
    public static  void  main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(100));
        System.out.println(sqrt.sqrt(10));

    }
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}
