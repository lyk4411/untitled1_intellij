package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyk on 2017/7/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ErecttheFence {
    static class Point {
             int x;
             int y;
             Point() { x = 0; y = 0; }
             Point(int a, int b) { x = a; y = b; }

        @Override
        public String toString() {
            return "Point(" + x + " , " + y + ")";
        }
    }
    public static void main(String[] args) {
        ErecttheFence ef = new ErecttheFence();
        Point[] points = new Point[6];
        Point point0 = new Point(1,1);
        Point point1 = new Point(2,2);
        Point point2 = new Point(2,0);
        Point point3 = new Point(2,4);
        Point point4 = new Point(3,3);
        Point point5 = new Point(4,2);
        points[0] = point0;
        points[1] = point1;
        points[2] = point2;
        points[3] = point3;
        points[4] = point4;
        points[5] = point5;
        System.out.println(ef.outerTrees(points));
    }

    public List<Point> outerTrees(Point[] points) {
        Set<Point> result = new HashSet<>();

        // Find the leftmost point
        Point first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < first.x) {
                first = points[i];
                firstIndex = i;
            }
        }
        result.add(first);

        Point cur = first;
        int curIndex = firstIndex;
        do {
            Point next = points[0];
            int nextIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (nextIndex == curIndex || cross > 0 ||
                        // Handle collinear points
                        (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                    next = points[i];
                    nextIndex = i;
                }
            }
            // Handle collinear points
            for (int i = 0; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (cross == 0) {
                    result.add(points[i]);
                }
            }

            cur = next;
            curIndex = nextIndex;

        } while (curIndex != firstIndex);

        return new ArrayList<Point>(result);
    }

    private int crossProductLength(Point A, Point B, Point C) {
        // Get the vectors' coordinates.
        int BAx = A.x - B.x;
        int BAy = A.y - B.y;
        int BCx = C.x - B.x;
        int BCy = C.y - B.y;

        // Calculate the Z coordinate of the cross product.
        return (BAx * BCy - BAy * BCx);
    }

    private int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }
}
