package leetcode;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by lyk on 2018-6-14.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for (int ast: asteroids) {
            collision: {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        AsteroidCollision ac = new AsteroidCollision();
        IntStream.of(ac.asteroidCollision(new int[]{5, 10, -5})).forEach(
                n -> System.out.print(n + " : ")
        );
        System.out.println();
        IntStream.of(ac.asteroidCollision(new int[]{-2, -1, 1, 2})).forEach(
                n -> System.out.print(n + " : ")
        );
    }
}
