package leetcode;

/**
 * Created by lyk on 2017/7/11.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class SolvetheEquation {
    public static void main(String[] args) {
        SolvetheEquation se = new SolvetheEquation();
        String eq1 = "x+5-3+x=6+x-2";
        String eq2 = "x=x";
        String eq3 = "2x+3x-6x=x+2";
        String eq4 = "x=x+2";
        System.out.println(se.solveEquation(eq1));
        System.out.println(se.solveEquation(eq2));
        System.out.println(se.solveEquation(eq3));
        System.out.println(se.solveEquation(eq4));
    }

    public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
                res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1]/res[0];
    }

    public int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
            else if (token.equals("-x")) res[0] -= 1;
            else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else res[1] += Integer.parseInt(token);
        }
        return res;
    }
}
