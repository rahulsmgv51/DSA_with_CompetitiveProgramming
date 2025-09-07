# Merge k Sorted Lists

## Problem Statement
You are given an array of `k` linked-lists, each linked-list is sorted in ascending order.  
Merge all the linked-lists into one sorted linked-list and return it.

**LeetCode Problem Link:** [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)

---

## Example

### Example 1:
**Input:**
lists = [[1,4,5],[1,3,4],[2,6]]

**Output:**
[1,1,2,3,4,4,5,6]

**Explanation:**
- The linked-lists are:
  - 1 → 4 → 5
  - 1 → 3 → 4
  - 2 → 6
- Merged list: 1 → 1 → 2 → 3 → 4 → 4 → 5 → 6

---

### Example 2:
**Input:**
lists = []

**Output:**
[]
---

### Example 3:
**Input:**
lists = [[]]

**Output:**
[]

---

## Constraints
- `k == lists.length`
- `0 <= k <= 10^4`
- `0 <= lists[i].length <= 500`
- `-10^4 <= lists[i][j] <= 10^4`
- The linked-lists are **sorted** in ascending order.

---

## Approach

We can solve this problem in multiple ways:

### **1. Min-Heap / Priority Queue (Efficient)**
- Use a min-heap (priority queue) to always extract the node with the smallest value.
- Insert the head of each linked list into the heap.
- Repeatedly extract the smallest node and push its `next` into the heap.
- Time Complexity: **O(N log k)**  
  - `N` = total number of nodes  
  - `k` = number of linked lists  
- Space Complexity: **O(k)** (heap size)

---

## Java Solution (Priority Queue)

```java
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all list heads to the priority queue
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
```
Alternative Approaches
Divide and Conquer (Merge sort style)

Recursively merge pairs of linked lists until one remains.

Time Complexity: O(N log k)

Brute Force

Collect all values into an array, sort them, and reconstruct the linked list.

Time Complexity: O(N log N)

Less efficient for large inputs.

Key Takeaways
Use a PriorityQueue for an elegant and efficient solution.

Divide-and-conquer merging also works well for this problem.

Always consider edge cases like empty lists or all null inputs.