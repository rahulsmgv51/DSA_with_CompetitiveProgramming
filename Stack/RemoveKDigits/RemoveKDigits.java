package Stack.RemoveKDigits;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String str =  "123456789";//"1234567890"; // "10200"; //"1432219";
        int k = 1;
        Solution objSolution = new Solution();
        System.out.println(objSolution.removeKdigits(str, k));
    }
}

class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove remaining digits if k > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Remove leading zeros
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String result = sb.substring(idx);
        return result.length() == 0 ? "0" : result;
    }
}


/* class Solution {
    public String removeKdigits(String num, int k) {
        if(k>=num.length()) return "0";

        Stack<Long> stack = new Stack<>();

        for(int i=0; i<num.length()-k; i++){
            String prev = (i==0) ? "":num.substring(0,i);
            String next = num.substring(i+k);
            Long curr = Long.parseLong(prev+next);
            while (!stack.isEmpty() && curr < stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && curr > stack.peek()) {
                continue;
            }else{
                stack.push(curr);
            }
        }

        return new String().valueOf(stack.pop());
    }
} */