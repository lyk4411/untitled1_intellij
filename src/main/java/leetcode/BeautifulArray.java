package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2019-2-5.
 * Package name: leetcode
 * Porject name: untitled1
 */
//题目：
//
//给定一个排列，要求给出其满足对于任意一个数A[k]，使得i<k<j，2*A[k]!=A[i]+A[j].的一个排列
//        思路：
//        构造题，emmmm，emmmmmm
//        先看一种简单的思路。
//        因为2*A[k]是偶数，如果要求2*A[K]!=A[I]+A[J]那么可以构造位置在A[k]左边的全部放奇数，位置在A[k]右边的全部放偶数。这样就保证了对于K位置而言，这个性质是满足的。
//        也许你就有疑问了，1,3,5,6,2,4.这组序列中，虽然对于6位置而言，左边全是奇数，右边全是偶数，但是全是奇数的那一边明显不满足要求。怎么解决呢？
//        习惯从幼儿园开始就要养成，左边是奇数，右边是偶数的形式也得从N比较小的时候开始。这里有一个递归的思想。因为长度为N的序列中，奇数个数为（N+1）/2，偶数个数为N/2，所以Beautiful Array（N）的排列，可以由Beautiful Array(N/2)和Beautiful Array((N+1)/2)组成，为什么这么说呢？
//        假设N  = 7，那么Beautiful Array(N/2) = 1,,3,2（满足题目性质）  Beautiful Array((N+1)/2) = 1 3  2  4.（满足题目性质）
//        那么 2*Beautiful Array((N+1)/2)-1（奇数在前）连接  2*Beautiful Array(N/2) = 1  5  3  7 | 2  6  4.（逐个元素进行操作）
//        我们可以观察到，对于这个分隔符而言，左边是奇数，右边是偶数，所以在分隔符位置，无疑是满足题目要求的性质的。而且，左边的奇数是从满足题目性质的数组进行线性运算得出的，所以并不会影响各个位置数字间的性质，（如1,3,5. 2*3==1+5，同时乘2之后这个性质依然成立）。既然组成这个大数组的子数组Beautiful Array(N/2)和Beautiful Array((N+1)/2)都满足性质，那么乘法之后的数组也依然满足题目要求。所以大数组左半部分和右半部分都满足题目要求。而中间分隔位置也满足性质，所以这一整个大数组也满足题目性质了。所以我们只需要保证Beautiful Array（1）满足题目性质就可以递推出所有的Beautiful Array（N）了。很明显Beautiful Array（1）没有别的选择，只能满足性质。

public class BeautifulArray {
    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return f(N);
    }

    public int[] f(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int t = 0;
            for (int x: f((N+1)/2))  // odds
                ans[t++] = 2*x - 1;
            for (int x: f(N/2))  // evens
                ans[t++] = 2*x;
        }
        memo.put(N, ans);
        return ans;
    }

    public static void main(String[] args) {
        BeautifulArray ba = new BeautifulArray();
        IntStream.of(ba.beautifulArray(6)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(ba.beautifulArray(16)).forEach(n -> System.out.print(n + " : "));
        System.out.println();
        IntStream.of(ba.beautifulArray(9)).forEach(n -> System.out.print(n + " : "));
    }
}
