package leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by lyk on 2018-4-20.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }
    public void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r-1, c, color, newColor);
            if (c >= 1) dfs(image, r, c-1, color, newColor);
            if (r+1 < image.length) dfs(image, r+1, c, color, newColor);
            if (c+1 < image[0].length) dfs(image, r, c+1, color, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] image = new int[][]{
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        Arrays.stream(Stream.of(ff.floodFill(image, 1, 1, 2)).
                flatMapToInt(x -> Arrays.stream(x)).toArray()).
                forEach(n -> System.out.print(n + " "));
        int[][] a = ff.floodFill(image, 1, 1, 2);
        System.out.println();
        for(int[] i : a){
            for(int j : i){
                System.out.print(j + " ");
            }
        System.out.println();
        }
    }
}
