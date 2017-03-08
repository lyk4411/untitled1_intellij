package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII unii = new UglyNumberII();
        System.out.println(unii.nthUglyNumber(278));
    }
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(res.size() < n){
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            res.add(min);
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;
        }
        return res.get(res.size()-1);
    }
}
