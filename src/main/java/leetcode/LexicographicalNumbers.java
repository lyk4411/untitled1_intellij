package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/5/3.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class LexicographicalNumbers {
    public static void main(String[] args) {
        LexicographicalNumbers ln = new LexicographicalNumbers();
        System.out.println(ln.lexicalOrder(15));
        System.out.println(ln.lexicalOrder(150));

    }
    //这种思路是按个位数遍历，在遍历下一个个位数之前，先遍历十位数，
    // 十位数的高位为之前的个位数，只要这个多位数并没有超过n，就可以
    // 一直往后遍历，如果超过了，我们除以10，然后再加1，如果加1后末尾
    // 形成了很多0，那么我们要用个while循环把0都去掉，然后继续运算，
    // 参见代码如下：
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> list = new ArrayList<>(n);
//        int curr = 1;
//        for (int i = 1; i <= n; i++) {
//            list.add(curr);
//            if (curr * 10 <= n) {
//                curr *= 10;
//            } else if (curr % 10 != 9 && curr + 1 <= n) {
//                curr++;
//            } else {
//                while ((curr / 10) % 10 == 9) {
//                    curr /= 10;
//                }
//                curr = curr / 10 + 1;
//            }
//        }
//        return list;
//    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }
}
