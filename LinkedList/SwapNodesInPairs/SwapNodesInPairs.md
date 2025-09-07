# Swap Nodes in Pairs
Swap every two adjacent nodes of a linked list and return its head.  
**Important:** You must swap nodes themselves, **not** the values inside them.

---

## Examples

**Example 1**  
Input: `1 → 2 → 3 → 4`  
Output: `2 → 1 → 4 → 3`

**Example 2**  
Input: `[]`  
Output: `[]`

**Example 3**  
Input: `1`  
Output: `1`

---

## Constraints

- Number of nodes in the list: `0 ≤ n ≤ 100`
- `-100 ≤ Node.val ≤ 100`
- Do it **in-place**. Extra O(1) space preferred (besides recursion stack if you use recursion).

---

## Intuition

Each swap only needs the **previous node** link and the **two nodes** to swap:

```
prev -> a -> b -> next
becomes
prev -> b -> a -> next
```

Use a **dummy** node before head to simplify swapping when the head itself changes.

---

## Approaches

### 1) Iterative (O(n) time, O(1) space) — Recommended
- Create `dummy` before `head`; set `prev = dummy`.
- While `prev.next` and `prev.next.next` exist:
  - Let `a = prev.next`, `b = a.next`.
  - Rewire: `a.next = b.next`, `b.next = a`, `prev.next = b`.
  - Move `prev = a` (the second node after swap).
- Return `dummy.next`.

### 2) Recursive (O(n) time, O(n) stack)
- Base: if `head == null` or `head.next == null` return `head`.
- Let `first = head`, `second = head.next`.
- `first.next = swapPairs(second.next)`
- `second.next = first`
- Return `second`.

---

## Dry Run (Iterative)

Start: `dummy -> 1 -> 2 -> 3 -> 4`  
- `prev=dummy, a=1, b=2` → rewire → `dummy -> 2 -> 1 -> 3 -> 4` ; `prev=1`  
- `a=3, b=4` → rewire → `dummy -> 2 -> 1 -> 4 -> 3` ; `prev=3`  
End: `2 -> 1 -> 4 -> 3`

---

## Edge Cases
- Empty list or single node → unchanged
- Odd number of nodes → last node remains as-is
- Negative or duplicate values → irrelevant (we swap nodes, not values)

---

## Code

### Java (Iterative)

```java
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;       
            ListNode b = a.next;          

            a.next = b.next;
            b.next = a;
            prev.next = b;

            prev = a;
        }
        return dummy.next;
    }
}
```

### Java (Recursive)

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;

        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }
}
```

### Python (Iterative)

```python
class Solution:
    def swapPairs(self, head):
        dummy = ListNode(0, head)
        prev = dummy
        while prev.next and prev.next.next:
            a = prev.next
            b = a.next
            a.next = b.next
            b.next = a
            prev.next = b
            prev = a
        return dummy.next
```

### C++ (Iterative)

```cpp
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode dummy(0, head);
        ListNode* prev = &dummy;

        while (prev->next && prev->next->next) {
            ListNode* a = prev->next;
            ListNode* b = a->next;

            a->next = b->next;
            b->next = a;
            prev->next = b;

            prev = a;
        }
        return dummy.next;
    }
};
```

---

## Complexity

- **Time:** O(n) — each node visited once  
- **Space:**  
  - Iterative: O(1) extra  
  - Recursive: O(n) call stack

---

## Unit Test Ideas

- `[]` → `[]`  
- `[1]` → `[1]`  
- `[1,2]` → `[2,1]`  
- `[1,2,3]` → `[2,1,3]`  
- `[1,2,3,4,5]` → `[2,1,4,3,5]`  
- `[1,1,1,1]` → `[1,1,1,1]`

---

## Notes

- Don’t modify `val`; only relink nodes.  
- The dummy node pattern generalizes to other pairwise/segment list problems.
