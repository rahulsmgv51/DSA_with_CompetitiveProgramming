# 🧩 Intersection of Two Linked Lists

## 🔗 LeetCode Problem Link:
[https://leetcode.com/problems/intersection-of-two-linked-lists/](https://leetcode.com/problems/intersection-of-two-linked-lists/)

---

## 📝 Problem Statement

Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

**Important Notes**:
- There are **no cycles** in either of the linked lists.
- The lists must retain their original structure after the function returns.
- Intersection is based on **reference**, not value.

---

## 🧪 Example 1

```
Input: 
  listA = [4,1,8,4,5], 
  listB = [5,6,1,8,4,5]
  skipA = 2, skipB = 3
  intersectVal = 8

Output: Reference to the node with value = 8
```

### Diagram:

```
List A: 4 → 1
               ↘
                 8 → 4 → 5
               ↗            
List B:    5 → 6 → 1
```

---

## 🧪 Example 2

```
Input: 
  listA = [1,9,1,2,4], 
  listB = [3,2,4]
  skipA = 3, skipB = 1
  intersectVal = 2

Output: Reference to the node with value = 2
```

---

## 🧪 Example 3

```
Input: 
  listA = [2,6,4], 
  listB = [1,5]
  intersectVal = 0

Output: null
```

---

## ✅ Constraints

- The number of nodes in `listA` is `m`.
- The number of nodes in `listB` is `n`.
- `1 <= m, n <= 3 * 10⁴`
- `1 <= Node.val <= 10⁵`
- `0 <= skipA < m`
- `0 <= skipB < n`
- `intersectVal` is `0` if the lists do not intersect.
- `intersectVal == listA[skipA] == listB[skipB]` if they do intersect.

---

## 🧠 Approach

We use the **two-pointer technique** to solve this in O(m + n) time and O(1) space:

- Traverse both lists with two pointers.
- When a pointer reaches the end of a list, switch it to the head of the other list.
- If there is an intersection, the pointers will meet at the intersecting node.
- If not, both pointers will eventually be `null`.

---

## 💻 Java Solution

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // Loop until both pointers meet or become null
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a; // Can be the intersection node or null
    }
}

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
```

---

## ⏱️ Time and Space Complexity

- **Time Complexity**: O(m + n)
- **Space Complexity**: O(1)

---

## 📌 Key Insights

- We are checking **node references**, not just values.
- The trick works because both pointers will traverse the same total length if there's an intersection.