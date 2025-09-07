# Reverse Nodes in k-Group

Reverse a linked list in groups of size `k`. If the number of nodes is not a multiple of `k`, leave the last remaining nodes as-is. Do it **in-place** with **O(1)** extra space (not counting recursion stack if you use recursion).

## Problem Summary

Given the head of a singly linked list and an integer `k (1 ≤ k ≤ 5000)`, reverse the nodes of the list `k` at a time and return the modified list. Nodes that don’t complete a full group of `k` at the end should remain in original order.

**Constraints**

* List length `n` can be up to \~10⁵ (platform dependent).
* Node values do not matter for the operation.
* Prefer iterative O(1) extra space.

## Examples

**Example 1**

```
Input:  head = [1,2,3,4,5], k = 2
Output: [2,1,4,3,5]
```

**Example 2**

```
Input:  head = [1,2,3,4,5], k = 3
Output: [3,2,1,4,5]
```

**Example 3**

```
Input:  head = [1,2], k = 3
Output: [1,2]    // fewer than k nodes → unchanged
```

**Example 4 (longer)**

```
Input:  head = [1,2,3,4,5,6,7,8,9,10], k = 4
Output: [4,3,2,1,8,7,6,5,9,10]
```

## Intuition

Process the list in windows of size `k`:

1. Peek ahead `k` nodes. If fewer than `k` remain → stop.
2. Reverse those `k` nodes in place.
3. Connect the previous chunk’s tail to the new head of this chunk, and the new tail to the next chunk’s head.
4. Repeat.

A **dummy** node simplifies handling the head when the first group is reversed.

### Visual (k = 3)

```
prev   a   b   c   next
  ↓    ↓   ↓   ↓    ↓
[dummy]->a->b->c->next → reverse (a,b,c)
[dummy]->c->b->a->next
         ^        ^
       newH     newT
```

## Algorithm (Iterative, O(1) space)

1. Create `dummy` → `dummy.next = head`. Set `groupPrev = dummy`.
2. While there are `k` nodes ahead of `groupPrev`:

   * Find `kth` (the kth node after `groupPrev`). Let `groupNext = kth.next`.
   * Reverse the nodes in `(groupPrev.next ... kth)`.
   * After reversing, let `newGroupHead = kth` and `newGroupTail = oldHead`.
   * Reconnect: `groupPrev.next = newGroupHead`, `newGroupTail.next = groupNext`.
   * Move `groupPrev = newGroupTail`.

**Time:** O(n) – each node visited and re-linked a constant number of times.

**Space:** O(1).

## Correctness Notes

* We only reverse when a full `k`-sized segment exists. A lookahead function `getKth` ensures this.
* Reversing sublist is standard pointer flips inside a bounded loop of size `k`.
* The dummy head ensures the list head is updated correctly for the first group.

## Java Implementation (Iterative, O(1) space)

```java
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            // 1) Find the kth node from groupPrev
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) break; // fewer than k nodes remain
            ListNode groupNext = kth.next;

            // 2) Reverse group [groupPrev.next .. kth]
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // 3) Reconnect
            ListNode newGroupHead = kth;               // after reverse
            ListNode newGroupTail = groupPrev.next;    // old head becomes tail
            groupPrev.next = newGroupHead;
            groupPrev = newGroupTail;                  // advance to next group
        }
        return dummy.next;
    }

    // Returns kth node from start (exclusive): move k steps from node
    private ListNode getKth(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start; // null if fewer than k remain
    }
}
```

### Why this reverse trick works

We initialize `prev = groupNext` so that when we finish reversing the block, the tail of the reversed block naturally points to the next block, eliminating a separate step.

## Alternative Approaches

* **Recursive**: Recursively reverse first `k`, then call on the rest. Elegant but uses O(n/k) stack depth (not O(1) space) and may hit recursion limits on very long lists.
* **Stack**: Push up to `k` nodes onto a stack and pop to rebuild. Simpler to reason about but uses O(k) extra space and extra pointer juggling.

## Edge Cases & Pitfalls

* `k = 1` → return original list.
* List length `< k` → unchanged.
* Keep references safe while reversing; losing `groupNext` or `curr.next` can break the list.
* Carefully move `groupPrev` to the **tail** of the just-reversed group, not to `kth`.

## Testing Checklist

* `[1], k=1` → `[1]`
* `[1,2], k=2` → `[2,1]`
* `[1,2,3], k=2` → `[2,1,3]`
* `[1,2,3,4,5], k=3` → `[3,2,1,4,5]`
* Long list where `n` is exactly divisible by `k` and where it isn’t.
* Randomized lists (property test: concatenation of reversed k-blocks equals reference implementation).

## Complexity

* **Time:** O(n)
* **Space:** O(1) extra (iterative version)

---

*Tip:* Use a small helper to print list nodes during local testing and dry run the pointer changes for one block to build intuition.