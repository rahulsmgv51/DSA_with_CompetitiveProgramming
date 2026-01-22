# Redundant Braces Detection

## Problem Statement

Given a mathematical expression as a string, determine whether it contains **redundant (unnecessary) parentheses**.

Redundant braces are those that **do not enclose any operator** (`+`, `-`, `*`, `/`).

### Examples

| Expression  | Result        |
| ----------- | ------------- |
| `(a+b)`     | Not Redundant |
| `((a+b))`   | Redundant     |
| `(a)`       | Redundant     |
| `(a+(b))`   | Redundant     |
| `(a+(b*c))` | Not Redundant |

---

## Approach Overview

The solution uses a **stack-based approach** to process the expression character by character.

The key idea is:

> When we encounter a closing parenthesis `)` we check whether there was **at least one operator** inside the matching `(` and `)`.

If **no operator** is found, the braces are redundant.

---

## Algorithm Logic (Step-by-Step)

1. Create an empty stack of characters.
2. Traverse each character of the input string.

### Case 1: Character is NOT `)`

* Push the character onto the stack.

### Case 2: Character is `)`

* Pop characters from the stack until `(` is found.
* While popping:

  * Check if any operator (`+`, `-`, `*`, `/`) exists.
* Remove the opening parenthesis `(` from the stack.

### Redundancy Check

* If **no operator was found** between `(` and `)` → **Redundant braces detected** → return `true`.

3. If the full expression is processed and no redundancy is found, return `false`.

---

## Code Implementation

```java
public boolean hasRedundantBraces(String s) {
    Stack<Character> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
        if (ch == ')') {
            boolean hasOperator = false;

            // Pop elements until opening brace '(' is found
            while (!stack.isEmpty() && stack.peek() != '(') {
                char top = stack.pop();
                if (top == '+' || top == '-' || top == '*' || top == '/') {
                    hasOperator = true;
                }
            }

            // Pop the opening '(' from stack
            stack.pop();

            // If no operator found, braces are redundant
            if (!hasOperator) {
                return true;
            }
        } else {
            stack.push(ch);
        }
    }

    return false;
}
```

---

## Time and Space Complexity

* **Time Complexity:** `O(n)` — each character is pushed and popped at most once.
* **Space Complexity:** `O(n)` — stack usage in the worst case.

---

## Key Takeaways

* Redundant braces are those without operators inside them.
* Stack is ideal for parsing expressions with parentheses.
* This approach efficiently detects unnecessary brackets in a single pass.

---

## Use Cases

* Compiler design
* Expression validation
* Code optimization checks
* Interview problem (Stack / Parsing category)

---