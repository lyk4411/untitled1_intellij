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
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    public int evaluate(String expression, Map<String, Integer> kv) {
        if (expression.charAt(0) == '(') {
            String nstr = expression.substring(1, expression.length() - 1);
            String[] data = nstr.split(" ");
            if (data[0].equals("let")) {
                List<String> splits = parse(expression);
                int n = splits.size();
                System.out.println(splits);
                for (int i = 0; i < n - 1; i += 2) {
                    kv.put(splits.get(i), evaluate(splits.get(i + 1), clone(kv)));
                }
                return evaluate(splits.get(n - 1), clone(kv));
            } else if (data[0].equals("add")) {
                List<String> splits = parse(expression);
                return evaluate(splits.get(0), clone(kv)) + evaluate(splits.get(1), clone(kv));
            } else {
                List<String> splits = parse(expression);
                return evaluate(splits.get(0), clone(kv)) * evaluate(splits.get(1), clone(kv));
            }
        } else {
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            } else {
                return kv.get(expression);
            }
        }
    }

    Map<String, Integer> clone(Map<String, Integer> map) {
        Map<String, Integer> clone = new HashMap<>();
        for (String key : map.keySet()) clone.put(key, map.get(key));
        return clone;
    }

    List<String> parse(String expression) {
        List<String> ans = new ArrayList<>();
        int n = expression.length() - 1;
        char[] exps = expression.toCharArray();
        int j = expression.substring(1, 4).equals("mul") ? 6 : 5;
        while (j < n) {
            if (exps[j] == '(') {
                int lf = 1;
                int i = j + 1;
                for (; i < n; ++i) {
                    if (exps[i] == '(') lf++;
                    if (exps[i] == ')') {
                        lf--;
                        if (lf == 0) {
                            break;
                        }
                    }
                }
                ans.add(expression.substring(j, i + 1));
                j = i + 2;
            } else {
                StringBuilder sb = new StringBuilder();
                while (j < n && exps[j] != ' ') {
                    sb.append(exps[j]);
                    j++;
                }
                j++;
                ans.add(sb.toString());
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ParseLispExpression ple = new ParseLispExpression();
        //System.out.println(ple.evaluate("(add 1 2)"));
        //System.out.println(ple.evaluate("(mult 3 (add 2 3))"));
        //System.out.println(ple.evaluate("(let x 2 (mult x 5))"));
        System.out.println(ple.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
//        System.out.println(ple.evaluate("(let x 3 x 2 x)"));
//        System.out.println(ple.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
//        System.out.println(ple.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
//        System.out.println(ple.evaluate("(let a1 3 b2 (add a1 1) b2)"));
    }
}
