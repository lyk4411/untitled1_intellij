package leetcode;

/**
 * Created by lyk on 2018-4-13.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        JudgeRouteCircle jrc = new JudgeRouteCircle();
        System.out.println(jrc.judgeCircle("LL"));
        System.out.println(jrc.judgeCircle("DU"));

    }
}
