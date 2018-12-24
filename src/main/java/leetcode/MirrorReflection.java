package leetcode;

/**
 * Created by lyk on 2018-12-24.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MirrorReflection {
//    题目大意
//
//    有个正方形的玻璃房子，从左下角射出一个光线，光线第一次打在右边墙上的高度是q。正方形边长是p，求最终这个光线射在了0,1,2的哪个位置。
//    解题方法
//
//    利用正方形的性质，其实可以看成两个平行的无限长的镜子。
//
//    此处输入图片的描述
//
//    找出m * p = n * q
//
//    m 是房子的拓展次数 + 1
//    n 是反射的拓展次数 + 1
//
//    显而易见，m 和 n 不可能都是偶数，否则会在之前就相遇。所以判断：
//
//    如果，光的反射是奇数，则n是偶数，所以角落在左手边，只能是2.
//            如果，光的反射是偶数，则n是偶数，所以角落在右手边，可能是0和1。在此基础上，如果房子的拓展是偶数，则m是奇数，所以角落是1，否则角落是0.
//
//            即：
//
//    m is even & n is odd => return 0.
//    m is odd & n is odd => return 1.
//    m is odd & n is even => return 2.
//
//    原文地址：https://blog.csdn.net/fuxuemingzhu/article/details/82432579
    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g; p %= 2;
        q /= g; q %= 2;

        if (p == 1 && q == 1) return 1;
        return p == 1 ? 0 : 2;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        MirrorReflection mr = new MirrorReflection();
        System.out.println(mr.mirrorReflection(2, 3));
        System.out.println(mr.mirrorReflection(2, 30));
        System.out.println(mr.mirrorReflection(20, 3));
        System.out.println(mr.mirrorReflection(12, 3));
        System.out.println(mr.mirrorReflection(12, 4));
        System.out.println(mr.mirrorReflection(11, 4));
    }
}
