package Stack.ValidParentheses;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(" isBalanced : "+isBalanced(str));
    }

    public static boolean isBalanced(String A) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (Character curr : A.toCharArray()) {
            if (curr == '(' || curr == '{' ||curr == '[' ) {
                stack.push(curr);
            }else{
                if (stack.isEmpty()) {
                    return false;
                }
                char opening = stack.pop();
                if ((opening == '(' && curr == ')') || (opening == '{' && curr == '}') || (opening == '[' && curr == ']')) {
                    continue;
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();        
    }
}