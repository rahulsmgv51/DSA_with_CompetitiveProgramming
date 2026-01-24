Remove K Digits
🧩 Problem Statement

Given a non-negative integer num represented as a string and an integer k, remove exactly k digits from the number so that the resulting number is the smallest possible.

The remaining digits must maintain their original relative order.

📌 Examples
Input	Output
num = "1432219", k = 3	"1219"
num = "10200", k = 1	"200"
num = "10", k = 2	"0"
🧠 Key Observations

Removing larger digits earlier helps minimize the number.

The order of remaining digits cannot be changed.

Leading zeros must be removed.

If all digits are removed, return "0".

🚀 Optimal Approach (Greedy + Monotonic Stack)
Idea

Use a monotonic increasing stack

Traverse digits from left to right

If the current digit is smaller than the stack top, remove the larger digit

Repeat until k digits are removed

Why Stack?

Allows us to compare and remove previous larger digits efficiently

Guarantees O(n) time complexity

🧪 Algorithm Steps

Initialize an empty stack

Traverse each digit in num

While:

k > 0

stack is not empty

stack top > current digit
→ pop from stack and decrement k

Push current digit

If k > 0, remove remaining digits from the end

Build the result

Remove leading zeros

Return "0" if result is empty

✅ Java Implementation
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

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') {
            idx++;
        }

        String result = sb.substring(idx);
        return result.length() == 0 ? "0" : result;
    }
}

⏱️ Complexity Analysis

Time Complexity: O(n)

Space Complexity: O(n)

Where n is the length of the input string.

❌ Common Mistakes to Avoid

Converting the number to int or long (fails for large inputs)

Trying all combinations (inefficient O(n²) or worse)

Forgetting to remove leading zeros

Not handling the case when all digits are removed