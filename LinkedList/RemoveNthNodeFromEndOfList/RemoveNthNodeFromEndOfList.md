# Remove N-th Node from End of List

## Problem Statement

Given a linked list `A`, remove the B-th node from the end of the list and return its head.

- If B exceeds the size of the list, remove the first node.
- Aim to solve the problem using constant additional space.

---

## Example 1

**Input:**
```
A = 1 -> 2 -> 3 -> 4 -> 5
B = 3
```

**Output:**
```
1 -> 2 -> 4 -> 5
```

**Explanation:**  
3 is the third last element.

---

## Example 2

**Input:**
```
A = 1 -> 2 -> 3 -> 4 -> 5
B = 7
```

**Output:**
```
2 -> 3 -> 4 -> 5
```

**Explanation:**  
Since B exceeds the length of the linked list, remove the first node (1).

---

## Constraints

- 1 ≤ |A| ≤ 10<sup>6</sup>
- 1 ≤ B ≤ 10<sup>6</sup>

## Solution

Here is a Java implementation for removing the N-th node from the end of a linked list:

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                // If n exceeds the length, remove the first node
                return head.next;
            }
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the target node
        slow.next = slow.next.next;
        return dummy.next;
    }
}
```
