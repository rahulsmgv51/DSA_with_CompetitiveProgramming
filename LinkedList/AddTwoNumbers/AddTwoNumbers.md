# Add Two Numbers

Add two non‑negative integers represented as **reverse-order** singly linked lists. Each node contains a single digit. Return the sum as a linked list in the same reverse order.

> Example: `l1 = [2,4,3]` (i.e., 342) and `l2 = [5,6,4]` (i.e., 465) ⇒ output: `[7,0,8]` (i.e., 807).

---

## 🔗 Problem

* **Platform:** LeetCode
* **ID:** 2
* **Title:** Add Two Numbers

---

## 🧩 Constraints

* Each list node stores a digit `0–9`.
* Lists are non-empty.
* Numbers do not have leading zeros (except the number 0 itself).
* Length of each list: up to \~10⁴ (varies by platform limits).

---

## 💡 Intuition

This is column-wise addition like on paper, but moving **from least significant digit to most** because the lists are in **reverse order**. Keep a `carry` as you go.

---

## ✅ Approach (Iterative, One Pass)

1. Initialize a dummy head node `dummy` and a pointer `cur = dummy`.
2. Track `carry = 0`.
3. While `l1` or `l2` exists **or** `carry > 0`:

   * `x = l1.val if l1 else 0`
   * `y = l2.val if l2 else 0`
   * `sum = x + y + carry`
   * `carry = sum // 10`
   * Create node with value `sum % 10` and attach to `cur.next`, move `cur`.
   * Advance `l1` and `l2` if present.
4. Return `dummy.next`.

**Time:** `O(n + m)`
**Space:** `O(1)` auxiliary (output list excluded).

---

## 🧪 Examples

**Example 1**
Input: `l1 = [2,4,3]`, `l2 = [5,6,4]`
Output: `[7,0,8]`
Reason: `342 + 465 = 807`.

**Example 2**
Input: `l1 = [0]`, `l2 = [0]`
Output: `[0]`.

**Example 3**
Input: `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]`
Output: `[8,9,9,9,0,0,0,1]`.

---

## ⚠️ Edge Cases & Pitfalls

* Different list lengths (e.g., `l1` longer than `l2`).
* Final leftover `carry` (e.g., `5 + 7` ⇒ node `2` and carry `1`).
* Very long lists—avoid converting to integers (overflow, slow). Always work node-by-node.

---

## 🧱 Data Structure (LeetCode style)

```text
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```

---

## 🧑‍💻 Java Solution

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
}
```

---

## 🐍 Python Solution

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def addTwoNumbers(self, l1, l2):
        dummy = ListNode()
        cur = dummy
        carry = 0

        while l1 or l2 or carry:
            x = l1.val if l1 else 0
            y = l2.val if l2 else 0
            s = x + y + carry
            carry = s // 10
            cur.next = ListNode(s % 10)
            cur = cur.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummy.next
```

---

## 🧭 Walkthrough (Example 342 + 465)

```
carry=0
(2+5+0)=7 -> node 7, carry=0
(4+6+0)=10 -> node 0, carry=1
(3+4+1)=8 -> node 8, carry=0
Result: 7 -> 0 -> 8
```

---

## 🧠 Variants / Follow-ups

1. **Add Two Numbers II** (LeetCode 445): digits are in **forward order**. Solutions:

   * Use stacks for both lists to simulate reverse order (O(n+m) time, O(n+m) space).
   * Or reverse the lists, add like here, then reverse the result.
2. **K Lists**: Add multiple numbers represented as lists → accumulate with a loop or reduce.
3. **Arbitrary base** `b` (2–16): replace `10` with `b` in carry logic.

---

## ✅ Testing Tips

* Minimal: `[0] + [0]` → `[0]`
* Carry chain: `[9,9,9] + [1]` → `[0,0,0,1]`
* Unequal lengths: `[2,4,3] + [5,6,4,9]` → `[7,0,8,9]`
* Single long list: `[1,8] + [0]` → `[1,8]`

---

## ⏱️ Complexity

* **Time:** `O(n + m)` where `n` and `m` are lengths of the input lists.
* **Space:** `O(1)` auxiliary; `O(n + m)` for output list.

---