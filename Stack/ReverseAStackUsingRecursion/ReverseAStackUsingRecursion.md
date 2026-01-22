🔄 Reverse a Stack Using Recursion
📌 Problem Statement

Given a stack of integers, reverse the stack using recursion only.

Constraints

No loops

No extra data structures (arrays / stacks)

🧠 Key Concept

A stack follows LIFO (Last In First Out).
Since we cannot directly insert an element at the bottom of a stack, we use recursion to temporarily remove elements and reinsert them in reverse order.

The call stack acts as an implicit auxiliary stack.

🛠️ Approach Overview

The solution uses two recursive functions:

1️⃣ reverseStack(stack)

Removes the top element

Recursively reverses the remaining stack

Inserts the removed element at the bottom

2️⃣ insertAtBottom(stack, element)

Inserts an element at the bottom of the stack using recursion

🔁 Visual Execution Flow (With Diagrams)
📥 Initial Stack
Top
 ┌───┐
 │ 5 │
 │ 4 │
 │ 3 │
 │ 2 │
 │ 1 │
 └───┘
Bottom

🔽 Step 1: Recursive Popping (reverseStack)

Each recursive call pops the top element:

Call Stack (Recursion)        Actual Stack
---------------------        -------------
reverseStack()               [1, 2, 3, 4]
   pop 5
reverseStack()               [1, 2, 3]
   pop 4
reverseStack()               [1, 2]
   pop 3
reverseStack()               [1]
   pop 2
reverseStack()               []
   pop 1


Now the stack is empty.

🔼 Step 2: Insert at Bottom While Unwinding

Elements are inserted at the bottom one by one:

insertAtBottom([], 1)
Stack → [1]

insertAtBottom([1], 2)
Stack → [2, 1]

insertAtBottom([2, 1], 3)
Stack → [3, 2, 1]

insertAtBottom([3, 2, 1], 4)
Stack → [4, 3, 2, 1]

insertAtBottom([4, 3, 2, 1], 5)
Stack → [5, 4, 3, 2, 1]

📤 Final Reversed Stack
Top
 ┌───┐
 │ 1 │
 │ 2 │
 │ 3 │
 │ 4 │
 │ 5 │
 └───┘
Bottom

📐 Pseudocode
function reverseStack(stack):
    if stack is empty:
        return
    top = pop stack
    reverseStack(stack)
    insertAtBottom(stack, top)

function insertAtBottom(stack, element):
    if stack is empty:
        push element
        return
    temp = pop stack
    insertAtBottom(stack, element)
    push temp

⏱️ Complexity Analysis
Metric	Complexity
Time Complexity	O(n²)
Space Complexity	O(n) (recursion stack)
Extra Data Structure	❌ None
🎯 Why Time Complexity is O(n²)

reverseStack is called n times

Each insertAtBottom takes O(n) time

Total → O(n × n) = O(n²)