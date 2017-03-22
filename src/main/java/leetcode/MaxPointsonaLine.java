package leetcode;

import java.util.HashMap;

/**
 * Created by lyk on 2017/3/22.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class MaxPointsonaLine {
    public static void main(String[] args) {
        MaxPointsonaLine mpl = new MaxPointsonaLine();
        Point[] points = new Point[]{new Point(40,-23),new Point(9,138),
                new Point(429,115),new Point(50,-17),new Point(-3,80),
                new Point(-10,33),new Point(5,-21),new Point(-3,80),
                new Point(-6,-65),new Point(-18,26),new Point(-6,-65),
                new Point(5,72),new Point(0,77),new Point(-9,86),
                new Point(10,-2),new Point(-8,85),new Point(21,130),
                new Point(18,-6),new Point(-18,26),new Point(-1,-15),
                new Point(10,-2),new Point(8,69),new Point(-4,63),
                new Point(0,3),new Point(-4,40),new Point(-7,84),
                new Point(-8,7),new Point(30,154),new Point(16,-5),
                new Point(6,90),new Point(18,-6),new Point(5,77),
                new Point(-4,77),new Point(7,-13),new Point(-1,-45),
                new Point(16,-5),new Point(-9,86),new Point(-16,11),
                new Point(-7,84),new Point(1,76),new Point(3,77),
                new Point(10,67),new Point(1,-37),new Point(-10,-81),
                new Point(4,-11),new Point(-20,13),new Point(-10,77),
                new Point(6,-17),new Point(-27,2),new Point(-10,-81),
                new Point(10,-1),new Point(-9,1),new Point(-8,43),
                new Point(2,2),new Point(2,-21),new Point(3,82),
                new Point(8,-1),new Point(10,-1),new Point(-9,1),
                new Point(-12,42),new Point(16,-5),new Point(-5,-61),
                new Point(20,-7),new Point(9,-35),new Point(10,6),
                new Point(12,106),new Point(5,-21),new Point(-5,82),
                new Point(6,71),new Point(-15,34),new Point(-10,87),
                new Point(-14,-12),new Point(12,106),new Point(-5,82),
                new Point(-46,-45),new Point(-4,63),new Point(16,-5),
                new Point(4,1),new Point(-3,-53),new Point(0,-17),
                new Point(9,98),new Point(-18,26),new Point(-9,86),
                new Point(2,77),new Point(-2,-49),new Point(1,76),
                new Point(-3,-38),new Point(-8,7),new Point(-17,-37),
                new Point(5,72),new Point(10,-37),new Point(-4,-57),
                new Point(-3,-53),new Point(3,74),new Point(-3,-11),
                new Point(-8,7),new Point(1,88),new Point(-12,42),
                new Point(1,-37),new Point(2,77),new Point(-6,77),
                new Point(5,72),new Point(-4,-57),new Point(-18,-33),
                new Point(-12,42),new Point(-9,86),new Point(2,77),
                new Point(-8,77),new Point(-3,77),new Point(9,-42),
                new Point(16,41),new Point(-29,-37),new Point(0,-41),
                new Point(-21,18),new Point(-27,-34),new Point(0,77),
                new Point(3,74),new Point(-7,-69),new Point(-21,18),
                new Point(27,146),new Point(-20,13),new Point(21,130),
                new Point(-6,-65),new Point(14,-4),new Point(0,3),
                new Point(9,-5),new Point(6,-29),new Point(-2,73),
                new Point(-1,-15),new Point(1,76),new Point(-4,77),
                new Point(6,-29)};
        System.out.println(mpl.maxPoints(points));

    }
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;

        HashMap<Double, Integer> result = new HashMap<Double, Integer>();
        int max=0;

        for(int i=0; i<points.length; i++){
            int duplicate = 1;//
            int vertical = 0;
            for(int j=i+1; j<points.length; j++){
                //handle duplicates and vertical
                if(points[i].x == points[j].x){
                    if(points[i].y == points[j].y){
                        duplicate++;
                    }else{
                        vertical++;
                    }
                }else{
                    double slope = points[j].y == points[i].y ? 0.0
                            : (1.0 * (points[j].y - points[i].y))
                            / (points[j].x - points[i].x);

                    if(result.get(slope) != null){
                        result.put(slope, result.get(slope) + 1);
                    }else{
                        result.put(slope, 1);
                    }
                }
            }

            for(Integer count: result.values()){
                if(count+duplicate > max){
                    max = count+duplicate;
                }
            }

            max = Math.max(vertical + duplicate, max);
            result.clear();
        }


        return max;
    }
}

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
