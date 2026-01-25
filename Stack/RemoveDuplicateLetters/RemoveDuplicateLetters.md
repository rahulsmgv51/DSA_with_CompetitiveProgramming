Remove Duplicate Letters
🧩 Problem Statement

Given a string s, remove duplicate letters so that every letter appears exactly once in the result.
The resulting string must be the lexicographically smallest among all possible results.

Relative order of characters must be preserved

s consists of lowercase English letters only

📌 Examples
Example 1

Input

cbabc


Output

abc

Example 2

Input

abcdd


Output

abcd

Example 3

Input

cbacdcbc


Output

acdb

🧠 Key Insight

To get the lexicographically smallest string:

We want smaller characters as early as possible

But we must ensure that every character appears exactly once

Greedy Rule

A character can be removed from the result only if:

It is lexicographically larger than the current character

It appears again later in the string

This naturally leads to a monotonic increasing stack solution.

🚀 Algorithm (Greedy + Monotonic Stack)

Count the frequency of each character

Use a visited[] array to ensure each character appears once

Traverse the string:

Decrease the frequency of the current character

If the character is already visited → skip it

While:

stack is not empty

stack top > current character

stack top appears later (freq[top] > 0)
→ pop from stack and mark unvisited

Push current character and mark it visited

Build the result from the stack

🧪 Dry Run Example
Input
cbacdcbc

Step-by-Step Execution
Step	Current Char	Stack Before	Action	Stack After	Reason
1	c	[]	Push c	[c]	Stack empty
2	b	[c]	Pop c, Push b	[b]	c > b and c appears later
3	a	[b]	Pop b, Push a	[a]	b > a and b appears later
4	c	[a]	Push c	[a, c]	a < c
5	d	[a, c]	Push d	[a, c, d]	c < d
6	c	[a, c, d]	Skip	[a, c, d]	c already used
7	b	[a, c, d]	Push b	[a, c, d, b]	d does not appear later
8	c	[a, c, d, b]	Skip	[a, c, d, b]	c already used
✅ Final Output
acdb

✅ Java Implementation
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] visited = new boolean[26];

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        // Step 2: Greedy traversal
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            // Already used character
            if (visited[idx]) continue;

            // Maintain lexicographical order
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[idx] = true;
        }

        // Step 3: Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}

⏱️ Complexity Analysis
Metric	Value
Time Complexity	O(n)
Space Complexity	O(1) (fixed 26 letters)
❌ Common Mistakes

Removing characters without checking if they appear later

Sorting characters (breaks order)

Not using a visited[] array

Comparing full strings instead of characters

🎯 Interview One-Liner

“This problem is solved using a greedy monotonic stack. We remove a character only if it is lexicographically larger than the current character and appears again later, ensuring the smallest possible unique-character string.”