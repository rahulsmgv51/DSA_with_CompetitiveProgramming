# Remove Linked List Elements  

## Problem Statement  
Given the `head` of a linked list and an integer `val`, remove all the nodes of the linked list that have `Node.val == val`, and return the new head.  

---

## Example 1  
**Input:**  
head = [1,2,6,3,4,5,6], val = 6


**Output:**  
[1,2,3,4,5]



---

## Example 2  
**Input:**  
head = [], val = 1


**Output:**  
[]



---

## Example 3  
**Input:**  
head = [7,7,7,7], val = 7


**Output:**  
[]



---

## Constraints  
- The number of nodes in the list is in the range `[0, 10⁴]`.  
- `1 <= Node.val <= 50`  
- `0 <= val <= 50`  

---

## Approach  

1. **Dummy Node Technique**:  
   - Create a dummy node before the head to simplify edge cases (like deleting the first node).  
   - Traverse the linked list with a pointer `current`.  
   - If `current.next.val == val`, remove that node by skipping it (`current.next = current.next.next`).  
   - Otherwise, move `current` forward.  

2. **Return** the updated list starting from `dummy.next`.  

---

## Pseudocode  
function removeElements(head, val):
dummy = new ListNode(0)
dummy.next = head
current = dummy


while current.next != null:
    if current.next.val == val:
        current.next = current.next.next
    else:
        current = current.next

return dummy.next

---

## Complexity Analysis  
- **Time Complexity:** `O(n)` – Each node is visited once.  
- **Space Complexity:** `O(1)` – No extra data structures used (except dummy node).  

---

## Solution in Java  
```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return dummy.next;
    }
}
---