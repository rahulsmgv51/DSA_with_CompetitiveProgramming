package Stack.LargestRectangleInHistogram;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int arr[] = {9, 9, 5, 7, 5, 2, 2, 1};
        System.out.println("largestRectangleArea : "+largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights){
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int L[] = new int[heights.length];
        int R[] = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop(); 
            }

            if(stack.isEmpty()){
                L[i] = -1;
            }else{
                L[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for(int i=R.length-1; i>=0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                R[i] = R.length;
            }else{
                R[i] = stack.peek();
            }
            stack.push(i);
        }
        int largeValue = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            largeValue = Math.max(largeValue, (R[i]-L[i]-1)*heights[i]);
        }

        return largeValue;
    }
}

class Solution
{
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        if (n == 0) return 0;
        if (n == 1) return heights[0];
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stk = new Stack <> ();
        for (int i = 0; i < n; i++)
        {
            while (!stk.empty() && heights[stk.peek()] >=
                heights[i])
                stk.pop();
            left[i] = (stk.empty() ? -1 : stk.peek());
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; i--)
        {
            while (!stk.empty() && heights[stk.peek()] >=
                heights[i])
                stk.pop();
            right[i] = (stk.empty() ? n : stk.peek());
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, (right[i] - left[i] - 1) *
                heights[i]);
        return ans;
    }
}
