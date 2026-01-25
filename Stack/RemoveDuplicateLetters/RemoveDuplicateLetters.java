package Stack.RemoveDuplicateLetters;

import java.util.Stack;

class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String str = "cbacdcbc";
        Solution obSolution = new Solution();
        System.out.println("Removed Duplicate : "+obSolution.removeDuplicateLetters(str));
    }
}

class Solution {
    public String removeDuplicateLetters(String str) {
        int freq[] = new int[26];
        boolean visited[] = new boolean[26];

        for (char ch : str.toCharArray()) {
            freq[ch-'a']++;
        }

        Stack<Character> stack = new Stack<>();
        for(char ch:str.toCharArray()){
            int idx = ch - 'a';
            freq[idx]--;

            if (visited[idx]) continue;

            while (!stack.isEmpty() && stack.peek() > ch && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);

        return sb.toString();
    }
}