package example;

/**
 * Created by lyk on 2017/7/5.
 * Package name: example
 * Porject name: untitled1
 */
public class testintAA {
    public static void main(String[] args) {
        int[][] a = new int[][]{};
        if(a.length == 0) {
            System.out.println("==================");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    System.out.print("  a[" + i + "][" + j + "]:" + a[i][j]);
                }
                System.out.println();
            }
        }
    }
}
