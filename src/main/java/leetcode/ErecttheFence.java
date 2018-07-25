package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by lyk on 2018-7-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ErecttheFence {
    public int orientation(Point p, Point q, Point r) {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    public boolean inBetween(Point p, Point i, Point q) {
        boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
        boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
        return a && b;
    }
    public List< Point > outerTrees(Point[] points) {
        HashSet< Point > hull = new HashSet < > ();
        if (points.length < 4) {
            for (Point p: points)
                hull.add(p);
            return new ArrayList<Point>(hull);
        }
        int left_most = 0;
        for (int i = 0; i < points.length; i++)
            if (points[i].x < points[left_most].x)
                left_most = i;
        int p = left_most;
        do {
            int q = (p + 1) % points.length;
            for (int i = 0; i < points.length; i++) {
                if (orientation(points[p], points[i], points[q]) < 0) {
                    q = i;
                }
            }
            for (int i = 0; i < points.length; i++) {
                if (i != p && i != q && orientation(points[p], points[i], points[q]) == 0 && inBetween(points[p], points[i], points[q])) {
                    hull.add(points[i]);
                }
            }
            hull.add(points[q]);
            p = q;
        }
        while (p != left_most);
        return new ArrayList<Point>(hull);
    }

    public static void main(String[] args) {
        ErecttheFence ef = new ErecttheFence();
        Point[] e1 = new Point[6];
        e1[0] = new Point(1,1);
        e1[1] = new Point(2,2);
        e1[2] = new Point(2,0);
        e1[3] = new Point(2,4);
        e1[4] = new Point(3,3);
        e1[5] = new Point(4,2);
        Point[] e2 = new Point[3];
        e2[0] = new Point(1,2);
        e2[1] = new Point(2,2);
        e2[2] = new Point(4,2);
        System.out.println(ef.outerTrees(e1));
        System.out.println(ef.outerTrees(e2));
    }
}
