import java.util.Stack;

public class RedundantBraces {
  public static void main(String[] args) {
    String str = "(a+(b*c))";
    Solution solution = new Solution();
    System.out.println("Has Redundant Braces : "+ solution.hasRedundantBraces(str));
  } 
}

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