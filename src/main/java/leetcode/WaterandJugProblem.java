package leetcode;

/**
 * Created by lyk on 2017/5/2.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class WaterandJugProblem {
    public static void main(String[] args) {
        WaterandJugProblem wjp = new WaterandJugProblem();
        System.out.println(wjp.canMeasureWater(3,4,5));
        System.out.println(wjp.canMeasureWater(3,5,4));
        System.out.println(wjp.canMeasureWater(2,6,5));
        System.out.println(wjp.canMeasureWater(2,6,8));
        System.out.println(wjp.canMeasureWater(2,6,10));

    }
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
