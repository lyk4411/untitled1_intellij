package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyk on 2018-6-12.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ParseLispExpression {
    ArrayList<Map<String, Integer>> scope;
    public ParseLispExpression() {
        scope = new ArrayList();
        scope.add(new HashMap());
    }

    public int evaluate(String expression) {
        scope.add(new HashMap());
        int ans = evaluate_inner(expression);
        scope.remove(scope.size() - 1);
        return ans;
    }

    public int evaluate_inner(String expression) {
        if (expression.charAt(0) != '(') {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-')
                return Integer.parseInt(expression);
            for (int i = scope.size() - 1; i >= 0; --i) {
                if (scope.get(i).containsKey(expression))
                    return scope.get(i).get(expression);
            }
        }

        List<String> tokens = parse(expression.substring(
                expression.charAt(1) == 'm' ? 6 : 5, expression.length() - 1));
        if (expression.startsWith("add", 1)) {
            return evaluate(tokens.get(0)) + evaluate(tokens.get(1));
        } else if (expression.startsWith("mult", 1)) {
            return evaluate(tokens.get(0)) * evaluate(tokens.get(1));
        } else {
            for (int j = 1; j < tokens.size(); j += 2) {
                scope.get(scope.size() - 1).put(tokens.get(j-1), evaluate(tokens.get(j)));
            }
            return evaluate(tokens.get(tokens.size() - 1));
        }
    }

    public List<String> parse(String expression) {
        List<String> ans = new ArrayList();
        int bal = 0;
        StringBuilder buf = new StringBuilder();
        for (String token: expression.split(" ")) {
            for (char c: token.toCharArray()) {
                if (c == '(') bal++;
                if (c == ')') bal--;
            }
            if (buf.length() > 0) buf.append(" ");
            buf.append(token);
            if (bal == 0) {
                ans.add(new String(buf));
                buf = new StringBuilder();
            }
        }
        if (buf.length() > 0)
            ans.add(new String(buf));

        return ans;
    }

    public static void main(String[] args) {
        ParseLispExpression ple = new ParseLispExpression();
        System.out.println(ple.evaluate("(add 1 2)"));
        System.out.println(ple.evaluate("(mult 3 (add 2 3))"));
        System.out.println(ple.evaluate("(let x 2 (mult x 5))"));
        System.out.println(ple.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(ple.evaluate("(let x 3 x 2 x)"));
        System.out.println(ple.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(ple.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(ple.evaluate("(let a1 3 b2 (add a1 1) b2)"));
    }
}
