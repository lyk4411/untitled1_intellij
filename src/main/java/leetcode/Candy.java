package leetcode;

import java.util.stream.IntStream;

/**
 * Created by lyk on 2017/4/17.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class Candy {
    public static void main(String[] args) {
        Candy cd = new Candy();
        int[] ratings = new int[]{1, 2, 3, 4, 1, 2, 3, 4, 1};
        System.out.println(cd.candy(ratings));
        //System.out.println(IntStream.of(ratings).peek(s -> System.out.print(s + " ")).sum());
    }

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int last = ratings.length - 1;
        int result = 0;
        for (int i = 1; i <= last; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = last - 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            result += candies[i];
        }
        result += ratings.length + candies[last];
        System.out.println(IntStream.of(candies).peek(s -> System.out.print(s + " ")).sum());

        return result;
    }
}
