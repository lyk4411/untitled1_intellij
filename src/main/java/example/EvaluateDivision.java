package example;

import java.util.*;

/**
 * Created by lyk on 2017/5/10.
 * Package name: example
 * Porject name: untitled1
 */
public class EvaluateDivision {
    public static void main(String[] args) {
        EvaluateDivision ed = new EvaluateDivision();
        String[][] equations = new String[][]{{"a", "b"},{"b", "c"},{"d", "c"}};
//        System.out.println(equations[0][0]);
//        System.out.println(equations[0][1]);
//        System.out.println(equations[1][0]);
//        System.out.println(equations[1][1]);
//        System.out.println(equations[2][0]);
//        System.out.println(equations[2][1]);

        double[] values = new double[]{2,3,4};
        String[][] queries = new String[][]{{"a", "c"},{"b", "a"},
                {"a", "e"},{"a", "a"},{"x", "x"}};
        double[] results = ed.calcEquation(equations,values,queries);
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
//        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
//        for (int i = 0; i < equations.length; i++) {
//            String[] equation = equations[i];
//            if (!pairs.containsKey(equation[0])) {
//                pairs.put(equation[0], new ArrayList<String>());
//                valuesPair.put(equation[0], new ArrayList<Double>());
//            }
//            if (!pairs.containsKey(equation[1])) {
//                pairs.put(equation[1], new ArrayList<String>());
//                valuesPair.put(equation[1], new ArrayList<Double>());
//            }
//            pairs.get(equation[0]).add(equation[1]);
//            pairs.get(equation[1]).add(equation[0]);
//            valuesPair.get(equation[0]).add(values[i]);
//            valuesPair.get(equation[1]).add(1/values[i]);
//        }
//
//        double[] result = new double[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            String[] query = queries[i];
//            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
//            if (result[i] == 0.0) result[i] = -1.0;
//        }
//        return result;
//    }
//
//    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
//                       HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
//        if (set.contains(start)) return 0.0;
//        if (!pairs.containsKey(start)) return 0.0;
//        if (start.equals(end)) return value;
//        set.add(start);
//
//        ArrayList<String> strList = pairs.get(start);
//        ArrayList<Double> valueList = values.get(start);
//        double tmp = 0.0;
//        for (int i = 0; i < strList.size(); i++) {
//            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
//            if (tmp != 0.0) {
//                break;
//            }
//        }
//        set.remove(start);
//        return tmp;
//    }
    HashMap<String, List<Info>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // build graph, use adjacent list
        map = new HashMap();
        for(int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if(!map.containsKey(equation[0])) map.put(equation[0], new ArrayList());
            map.get(equation[0]).add(new Info(equation[1], values[i]));

            if(!map.containsKey(equation[1])) map.put(equation[1], new ArrayList());
            map.get(equation[1]).add(new Info(equation[0], 1 / values[i]));
        }

        double[] result = new double[queries.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = find(queries[i][0], queries[i][1], 1, new HashSet());
        }
        return result;
    }

    private double find(String start, String end, double value, Set<String> visited) {
        if(visited.contains(start)) return -1;
        if(!map.containsKey(start)) return -1;

        if(start.equals(end)) return value;
        visited.add(start);
        for(Info next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if(sub != -1.0) return sub;
        }

        //visited.remove(start);
        return -1;
    }

    class Info {
        String den;
        double val;
        Info(String den, double val) { this.den = den; this.val = val; }
    }
}
