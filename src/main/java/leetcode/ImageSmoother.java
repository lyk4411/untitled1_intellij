package leetcode;

/**
 * Created by lyk on 2018-4-16.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r-1; nr <= r+1; ++nr)
                    for (int nc = c-1; nc <= c+1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }

    public static void main(String[] args) {
        ImageSmoother is = new ImageSmoother();
        int[][] m = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] result = is.imageSmoother(m);
        for (int i = 0; i < result.length; i++){
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
