# Remove Duplicates from Sorted List II

## Problem Description

Given the head of a sorted linked list, delete all nodes that have
duplicate numbers, leaving only distinct numbers from the original
list.\
Return the linked list **sorted** as well.

------------------------------------------------------------------------

### Example 1:

**Input:**

    head = [1,2,3,3,4,4,5]

**Output:**

    [1,2,5]

------------------------------------------------------------------------

### Example 2:

**Input:**

    head = [1,1,1,2,3]

**Output:**

    [2,3]

------------------------------------------------------------------------

## Constraints

-   The number of nodes in the list is in the range **\[0, 300\]**.
-   `-100 <= Node.val <= 100`
-   The list is **sorted** in ascending order.

------------------------------------------------------------------------

## Approach

1.  Use a **dummy node** before the head to handle edge cases easily.
2.  Traverse the list:
    -   If the current node has duplicates (same value appearing
        consecutively), skip all nodes with that value.
    -   Otherwise, link it normally.
3.  Return `dummy.next` as the new head.

------------------------------------------------------------------------

## Solution (Python)

``` python
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy = ListNode(0, head)
        prev = dummy

        while head:
            # If current node has duplicates
            if head.next and head.val == head.next.val:
                # Skip all nodes with this value
                while head.next and head.val == head.next.val:
                    head = head.next
                prev.next = head.next
            else:
                prev = prev.next
            head = head.next

        return dummy.next
```

------------------------------------------------------------------------

## Solution (Java)

``` java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // If current node has duplicates
            if (head.next != null && head.val == head.next.val) {
                // Skip all nodes with this value
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}
```

------------------------------------------------------------------------

## Time & Space Complexity

-   **Time Complexity:** `O(n)` → Traverse each node once.
-   **Space Complexity:** `O(1)` → No extra space apart from pointers.

------------------------------------------------------------------------