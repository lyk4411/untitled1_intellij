package leetcode;

/**
 * Created by lyk on 2017/6/8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] flowerber1 = new  int[]{1,0,0,1,0,0,0,1};
        int[] flowerber2 = new  int[]{1,0,0,1,0,0,0,1};
        int[] flowerber3 = new  int[]{1,0,0,1,0,0,0,1};
//        for (int i = 0; i < flowerber.length; i++) {
//            if(flowerber[i] == 0){
//                System.out.println("flowerber[" + i + "]: true." );
//            }
//        }
        System.out.println(cpf.canPlaceFlowers(flowerber1,2));
        System.out.println(cpf.canPlaceFlowers(flowerber2,1));
        System.out.println(cpf.canPlaceFlowers(flowerber3,0));
    }
    public boolean canPlaceFlowers(int[] bed, int n) {
        for (int i = 0; i < bed.length; i++) {
            if (bed[i] == 0 && (i == 0 || bed[i - 1] == 0) && (i == bed.length - 1 || bed[i + 1] == 0)) {
                bed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
