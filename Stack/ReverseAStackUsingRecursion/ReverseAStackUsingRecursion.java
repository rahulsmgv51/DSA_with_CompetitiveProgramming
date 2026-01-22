package Stack.ReverseAStackUsingRecursion;

import java.util.Stack;

public class ReverseAStackUsingRecursion {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Solution objSolution = new Solution();
        objSolution.reverseStack(stack);
        System.out.println(stack);
    }
}




class Solution {
    public void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        insertAtBottom(s, top);
    }

    public void insertAtBottom(Stack<Integer> stack, int ele){
        
        if (stack.isEmpty()) {
            stack.push(ele);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, ele);
        stack.push(top);
    }
}