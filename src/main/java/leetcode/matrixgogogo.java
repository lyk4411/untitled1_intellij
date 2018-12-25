package leetcode;

/**
 * Created by lyk on 2018-12-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class matrixgogogo {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int size = 1; size <= matrix.length; ++size)
            for (int i = 0; i + size <= matrix[0].length; ++i) {
                int j = i + size - 1;
                System.out.println("matrix[" + i + "][" + j + "]:" + matrix[i][j]);
            }
        System.out.println("=====================================");
        int[][] a = {{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16}};

        matrixgogogo matrixgogogo = new matrixgogogo();
        matrixgogogo.print(a,4);

        System.out.println("=====================================");
        int[][] arr = new int[][] {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 },
        };

        matrixgogogo.slash(arr);
        System.out.println("=====================================");
        matrixgogogo.backslash(arr);



    }
    private void print(int a[][], int n) {
        int row;
        int col;
        //输出右上角代码，包括对角线上的元素
        for (int i = n - 1; i >= 0; i--) {//每次都是从第0行开始，所以需要row = 0,然后row  col  同时自增
            row = 0;
            col = i;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.print("a[" + row + "][" + col + "]:" + a[row][col] + " ");
                row++;
                col++;
            }
            System.out.println("");
        }

        //for输出左下角代码，对角线上的元素已经打印完了，所以在这里从1开始
        for (int i = 1; i <= n - 1; i++) {//每次都是从第0列开始，所以需要col = 0,然后row  col  同时自增
            row = i;
            col = 0;
            while (row >= 0 && row < n && col >= 0 && col < n) {
                System.out.print("a[" + row + "][" + col + "]:" + a[row][col] + " ");
                row++;
                col++;
            }
            System.out.println();
        }
    }//print
    public static void slash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int col = arr[0].length;
        int row = arr.length;
        for( int k = 0 ; k < col * 2 -1 ; k++ ) {     //k代表有多少行输出，由col决定
            int sum = k;                              //同一行的元素，行下标和列下标的和相等
            for( int j = 0 ; j < col ; j++ ) {
                int i = sum - j;
                if(isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print("arr[" + i + "][" + j + "]:" + arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void backslash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int row = arr.length;
        int col = arr[0].length;
        for (int k = 0; k < col * 2 - 1; k++) {     //k代表有多少行输出，由col决定
            int diff = col - k - 1;                 //同一行的元素，行下标和列下标的差相等
            for (int j = 0; j < col; j++) {
                int i = j - diff;
                if (isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print("arr[" + i + "][" + j + "]:" + arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int i, int n) {
        return i >= 0 && i < n;
    }
}
