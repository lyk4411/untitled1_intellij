package example;

/**
 * Created by lyk on 2017/4/20.
 * Package name: example
 * Porject name: untitled1
 */
public class PowerofFour {
    public static void main(String[] args) {
        PowerofFour pf = new PowerofFour();
        System.out.println(pf.isPowerOfFour(16));
        System.out.println(pf.isPowerOfFour(1));
        System.out.println(pf.isPowerOfFour(0));
    }
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }
}
