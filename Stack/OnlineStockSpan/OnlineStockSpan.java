package Stack.OnlineStockSpan;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        // Sample Input
        int[] prices = {100, 80, 60, 70, 60, 75};

        System.out.println("Input Prices:");
        for (int p : prices) {
            System.out.print(p + " ");
        }
        System.out.println("\n\nOutput Spans:");

        // Calling next() for each price
        for (int price : prices) {
            int span = spanner.next(price);
            System.out.print(span + " ");
        }
    }
}

class StockSpanner {
    private Deque<int[]> stack;  // {price, span}

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}
