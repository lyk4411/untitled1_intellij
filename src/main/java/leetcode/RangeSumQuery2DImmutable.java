package leetcode;

/**
 * Created by lyk on 2017/3/27.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        RangeSumQuery2DImmutable rsqi = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rsqi.sumRegion(2,2,4,4));

    }
    int [][] sum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if(matrix==null || matrix.length==0||matrix[0].length==0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];

        for(int i=0; i<m; i++){
            int sumRow=0;
            for(int j=0; j<n; j++){
                if(i==0){
                    sumRow += matrix[i][j];
                    sum[i][j]=sumRow;
                }else{
                    sumRow += matrix[i][j];
                    sum[i][j]=sumRow+sum[i-1][j];
                }

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.sum==null)
            return 0;

        int topRightX = row1;
        int topRightY = col2;

        int bottomLeftX=row2;
        int bottomLeftY= col1;

        int result=0;

        if(row1==0 && col1==0){
            result = sum[row2][col2];
        }else if(row1==0){
            result = sum[row2][col2]
                    -sum[bottomLeftX][bottomLeftY-1];

        }else if(col1==0){
            result = sum[row2][col2]
                    -sum[topRightX-1][topRightY];
        }else{
            result = sum[row2][col2]
                    -sum[topRightX-1][topRightY]
                    -sum[bottomLeftX][bottomLeftY-1]
                    +sum[row1-1][col1-1];
        }

        return result;
    }
}
