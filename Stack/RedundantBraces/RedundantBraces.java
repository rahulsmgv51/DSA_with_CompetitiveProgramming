import java.util.Stack;

class Solution {
    public boolean hasRedundantBraces(String s) {
      Stack<Character> stack = new Stack<>();

      for(char ch: s.toCharArray()){
        if(ch == ')'){
          boolean hasOperator = false;
          while(!stack.isEmpty() && !(stack.peek() == '(')){
            char top = stack.pop();
            if (top == '+' || top == '-' || top == '*' || top == '/') {
                hasOperator = true;
            }
          }
          stack.pop();
          if (!hasOperator) {
              return true;
          }
        }
        else{
          stack.push(ch);
        }
      }

      return false;
    }
}