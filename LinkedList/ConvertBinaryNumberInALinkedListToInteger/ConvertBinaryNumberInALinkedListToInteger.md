# Convert Binary Number in a Linked List to Integer

## Problem Description

You are given the `head` of a **singly linked list** where each node has
a value of either `0` or `1`.

The linked list represents a **binary number** in the order from most
significant bit (MSB) to least significant bit (LSB).

Return the **decimal value** of the number represented in the linked
list.

------------------------------------------------------------------------

### Example 1:

**Input:**

    head = [1,0,1]

**Explanation:** - Binary number = `101`
- Decimal value = `5`

**Output:**

    5

------------------------------------------------------------------------

### Example 2:

**Input:**

    head = [0]

**Output:**

    0

------------------------------------------------------------------------

### Constraints:

-   The Linked List is not empty.
-   The number of nodes will not exceed `30`.
-   Each node's value is either `0` or `1`.

------------------------------------------------------------------------

## Approach

### Method 1: Iterative (Bit Manipulation)

1.  Initialize a variable `num = 0`.
2.  Traverse the linked list:
    -   For each node, left shift `num` by 1 (`num = num << 1`).
    -   Add the current node's value (`num = num | node.val`).
3.  Return `num`.

This works because shifting left is equivalent to multiplying by 2 in
binary, and adding the new bit appends it at the end.

**Time Complexity:** `O(n)` -- traverse the list once.\
**Space Complexity:** `O(1)` -- only integer storage used.

------------------------------------------------------------------------

## Step-by-Step Dry Run

For input:

    head = [1, 0, 1]

-   Start with `num = 0`

1.  First node = `1`\
    `num = (0 << 1) | 1 = 0 | 1 = 1`

2.  Second node = `0`\
    `num = (1 << 1) | 0 = 2 | 0 = 2`

3.  Third node = `1`\
    `num = (2 << 1) | 1 = 4 | 1 = 5`

-   Final Answer: `5`

------------------------------------------------------------------------

## Solution Code (Java)

``` java
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
    }
}
```

------------------------------------------------------------------------

## Solution Code (Python)

``` python
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        num = 0
        while head:
            num = (num << 1) | head.val
            head = head.next
        return num
```