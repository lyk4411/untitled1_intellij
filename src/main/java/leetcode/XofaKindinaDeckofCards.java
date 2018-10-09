package leetcode;

/**
 * Created by lyk on 2018-10-10.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

    public static void main(String[] args) {
        XofaKindinaDeckofCards xkdc = new XofaKindinaDeckofCards();
        System.out.println(xkdc.hasGroupsSizeX(new int[]{1,2,3,4,4,3,2,1}));
        System.out.println(xkdc.hasGroupsSizeX(new int[]{1,1,1,1,1,1,2,2,2,2,2}));
        System.out.println(xkdc.hasGroupsSizeX(new int[]{1,1,1,1,2,2,2,2,4,4,4,4,4,4,4,4}));
        System.out.println(xkdc.hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3,3,3,3,3}));

    }
}
