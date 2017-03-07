package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lyk on 2017/3/6.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Triangle {
    public static void main(String[] args) {
        Triangle tr = new Triangle();
        List<Integer> a =new ArrayList<>();
        List<Integer> b =new ArrayList<>();
        List<Integer> c =new ArrayList<>();
        List<Integer> d =new ArrayList<>();

        a.add(2);
        b.add(3);
        b.add(4);
        c.add(6);
        c.add(5);
        c.add(7);
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        List<List<Integer>> aa = new ArrayList<List<Integer>>();
        aa.add(a);
        aa.add(b);
        aa.add(c);
        aa.add(d);
        System.out.println(tr.minimumTotal1(aa));
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for (int k = 0; k < A.length; k++) {
            System.out.print(A[k] + ";");
        }
        System.out.println();
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
            for (int k = 0; k < A.length; k++) {
                System.out.print(A[k] + ";");
            }
            System.out.println();
        }
        return A[0];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return Integer.MAX_VALUE;
        }

        int size = triangle.size();

        int[][] f = new int[size][size];

        f[0][0] = triangle.get(0).get(0);
        //initialize the diagonal
        for(int i = 1; i < size; i++ ) {
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
            for(int j=0;j< f.length;j++) {
                for (int k = 0; k < f[j].length; k++) {
                    System.out.print(f[j][k] + ";");
                }
                System.out.println();
            }
        }
        System.out.println("================================");

        for(int i = 1 ; i < size; i++) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);

            for(int j=0;j< f.length;j++) {
                for (int k = 0; k < f[j].length; k++) {
                    System.out.print(f[j][k] + ";");
                }
                System.out.println();
            }
        }
        System.out.println("================================");

        for(int i = 1; i < size; i++){
            for(int j = 1; j < i;j++) {
                f[i][j] = triangle.get(i).get(j) + Math.min(f[i - 1][j - 1], f[i - 1][j]);

                for(int l=0;l< f.length;l++) {
                    for (int k = 0; k < f[l].length; k++) {
                        System.out.print(f[l][k] + ";");
                    }
                    System.out.println();
                }
            }
        }

        int min = f[size - 1][0];
        for(int k = 1; k < size; k++) {
            min = Math.min(min, f[size - 1][k]);
        }
        return min;
    }
}
