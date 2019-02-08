package leetcode;

import java.util.Stack;

/**
 * Created by lyk on 2019-2-8.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class OnlineStockSpan {
    Stack<Integer> prices, weights;

    public OnlineStockSpan() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }

    public static void main(String[] args) {
        OnlineStockSpan oss = new OnlineStockSpan();
        System.out.println(oss.next(100));
        System.out.println(oss.next(80));
        System.out.println(oss.next(60));
        System.out.println(oss.next(70));
        System.out.println(oss.next(60));
        System.out.println(oss.next(75));
        System.out.println(oss.next(85));

    }
}
