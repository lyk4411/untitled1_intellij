package leetcode;

/**
 * Created by lyk on 2018-5-31.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                rec1[3] <= rec2[1] ||   // bottom
                rec1[0] >= rec2[2] ||   // right
                rec1[1] >= rec2[3]);    // top
    }

    public static void main(String[] args) {
        RectangleOverlap ro = new RectangleOverlap();
        int[] r1 = new int[]{0,0,2,2};
        int[] r2 = new int[]{1,1,3,3};
        int[] r3 = new int[]{0,0,1,1};
        int[] r4 = new int[]{1,0,2,1};
        System.out.println(ro.isRectangleOverlap(r1,r2));
        System.out.println(ro.isRectangleOverlap(r3,r4));

    }
}
