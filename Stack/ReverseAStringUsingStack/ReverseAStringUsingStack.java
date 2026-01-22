package Stack.ReverseAStringUsingStack;

import java.util.Stack;

public class ReverseAStringUsingStack {
    public static void main(String[] args) {
        char[] str = { 'a', 'b', 'c', 'd', 'e' };
        Solution objSolution = new Solution();
        objSolution.reverseString(str);
        for (char c : str) {
            System.out.print(c);
        }
    }
}

class Solution {
    public char[] reverseString(char[] s) {
        if (s.length == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length) {
            stack.push(s[i]);
            i++;
        }
        i = 0;
        while (!stack.isEmpty()) {
            s[i++] = stack.pop();
        }
        return s;
    }
}