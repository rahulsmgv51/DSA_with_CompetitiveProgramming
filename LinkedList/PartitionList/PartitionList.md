# Partition List

## Problem Statement
Given the head of a linked list and a value `x`, partition it such that all nodes less than `x` come before nodes greater than or equal to `x`.  

You must **preserve the original relative order** of the nodes in each partition.

---

## Examples

### Example 1
**Input:**
head = [1,4,3,2,5,2], x = 3

makefile
Copy code

**Output:**
[1,2,2,4,3,5]

yaml
Copy code

---

### Example 2
**Input:**
head = [2,1], x = 2

makefile
Copy code

**Output:**
[1,2]

yaml
Copy code

---

## Constraints
- The number of nodes in the list is in the range `[0, 200]`.
- `-100 <= Node.val <= 100`
- `-200 <= x <= 200`

---

## Approach
1. Create two dummy lists:
   - One for nodes **less than x**.
   - One for nodes **greater than or equal to x**.
2. Traverse the original list:
   - Append each node to the correct list.
3. Connect both lists together.
4. Return the new head (ignoring dummy nodes).

This ensures the **relative order** within each partition is preserved.

---

## Code (Java)

```java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;  
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
```
Complexity Analysis
Time Complexity: O(n) → Each node is visited once.

Space Complexity: O(1) → Only dummy nodes used (no extra data structures).

Dry Run (Example 1)
Input: head = [1,4,3,2,5,2], x = 3

Start with two lists: before = [], after = []

Traverse:

1 < 3 → before = [1]

4 ≥ 3 → after = [4]

3 ≥ 3 → after = [4,3]

2 < 3 → before = [1,2]

5 ≥ 3 → after = [4,3,5]

2 < 3 → before = [1,2,2]

Connect → [1,2,2,4,3,5]