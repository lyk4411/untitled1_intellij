package leetcode;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] flowerber = new  int[]{1,0,0,1,0,0,0,1};
        System.out.println(cpf.canPlaceFlowers(flowerber,2));
        System.out.println(cpf.canPlaceFlowers(flowerber,1));
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
                int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if(next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count == n;
    }
}
