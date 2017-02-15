package leetcode;

/**
 * Created by lyk on 2017/2/15.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ConstructtheRectangle {
    public static void main(String[] args){
        ConstructtheRectangle ctr = new ConstructtheRectangle();
        int[] a = ctr.constructRectangle(17);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (area%w!=0) w--;
        return new int[]{area/w, w};
    }
}
