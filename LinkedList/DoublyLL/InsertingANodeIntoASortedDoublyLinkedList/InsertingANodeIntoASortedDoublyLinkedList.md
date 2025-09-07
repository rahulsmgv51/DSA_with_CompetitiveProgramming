# 📄 Inserting a Node Into a Sorted Doubly Linked List

## 📌 Problem Overview
You are given the head pointer of a **sorted doubly linked list** and a value `data`.  
Your task is to **insert a new node** containing `data` into the correct sorted position **without breaking the doubly linked list structure**.

> The **doubly linked list** has two pointers per node:
> - `next` → points to the next node in the list.
> - `prev` → points to the previous node in the list.

---

## 🎯 Goal
- Maintain the **sorted order** of the linked list.
- Ensure **both `next` and `prev` pointers** are correctly updated.
- Return the **head node** of the updated list.

---

## 📥 Input Format
You are provided:
1. **`head`** → A reference to the first node of a **sorted** doubly linked list.  
   - Can be `None` (empty list).
2. **`data`** → An integer value to be inserted into the list.

---

## 📤 Output Format
Return:
- The **head node** of the updated doubly linked list **after** insertion.

---

## 📊 Example Walkthrough

### Example 1 — Insert in the Middle
**Input List:**  
```
1 <-> 3 <-> 4 <-> 10
```
**Data to insert:** `5`

**Process:**
1. Traverse until you find a node with a value **greater than or equal to 5**.
2. Insert `5` between `4` and `10`.
3. Update pointers accordingly.

**Output List:**  
```
1 <-> 3 <-> 4 <-> 5 <-> 10
```

---

### Example 2 — Insert at the Beginning
**Input List:**  
```
2 <-> 4 <-> 6
```
**Data to insert:** `1`

**Output List:**  
```
1 <-> 2 <-> 4 <-> 6
```

---

### Example 3 — Insert at the End
**Input List:**  
```
2 <-> 4 <-> 6
```
**Data to insert:** `8`

**Output List:**  
```
2 <-> 4 <-> 6 <-> 8
```

---

## 💡 Constraints
- The given linked list is **already sorted** (ascending).
- `0 ≤ list length ≤ 1000`
- `-1000 ≤ data ≤ 1000`
- Must handle insertion at:
  - Beginning of the list.
  - Middle of the list.
  - End of the list.
  - Empty list case.

---

## 🔍 Key Points to Remember
- **Doubly linked list vs singly linked list**:  
  In a doubly linked list, you must update **two pointers** (`prev` and `next`), not just one.
- **Edge cases**:
  - Empty list → new node becomes head.
  - Insert before the current head.
  - Insert after the last node.
- Pointer updates are crucial — a single wrong link can break the list.

---

## 🧩 Step-by-Step Algorithm
1. **Create a new node** with the given `data`.
2. **If the list is empty**, return the new node as `head`.
3. **If `data` is less than or equal to head’s data**:
   - Insert at the beginning.
   - Update new node’s `next` to point to old head.
   - Update old head’s `prev` to point to new node.
   - Return the new node as the head.
4. Otherwise:
   - Start from head and traverse until:
     - You find a node where `current.data >= data` (insert before it).
     - Or reach the end (insert at last).
5. **Adjust pointers**:
   - When inserting in the middle:
     - Connect `newNode.prev` to `current.prev`
     - Connect `current.prev.next` to `newNode`
     - Connect `newNode.next` to `current`
     - Connect `current.prev` to `newNode`
   - When inserting at the end:
     - Set last node’s `next` to newNode
     - Set `newNode.prev` to last node
6. Return the original head.

---

## 📜 Pseudocode
```
function sortedInsert(head, data):
    newNode = Node(data)

    if head is NULL:
        return newNode

    if data <= head.data:
        newNode.next = head
        head.prev = newNode
        return newNode

    current = head
    while current.next != NULL and current.data < data:
        current = current.next

    if current.data >= data:
        prevNode = current.prev
        prevNode.next = newNode
        newNode.prev = prevNode
        newNode.next = current
        current.prev = newNode
    else:
        current.next = newNode
        newNode.prev = current

    return head
```

---

## 🖥 Sample Implementation (Python)
```python
class DoublyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.prev = None

def sortedInsert(head, data):
    new_node = DoublyLinkedListNode(data)

    # Case 1: Empty list
    if not head:
        return new_node

    # Case 2: Insert before head
    if data <= head.data:
        new_node.next = head
        head.prev = new_node
        return new_node

    current = head

    # Traverse until correct position
    while current.next and current.data < data:
        current = current.next

    # Insert in the middle
    if current.data >= data:
        prev_node = current.prev
        prev_node.next = new_node
        new_node.prev = prev_node
        new_node.next = current
        current.prev = new_node
    else:
        # Insert at the end
        current.next = new_node
        new_node.prev = current

    return head
```

---

## 🖼 Diagram — Insertion in the Middle
Before inserting `5` in `1 <-> 3 <-> 4 <-> 10`:

```
 4.next → 10
10.prev → 4
```

After inserting:

```
 4.next → 5
 5.prev → 4
 5.next → 10
10.prev → 5
```

---

## 🔗 HackerRank Challenge Link
[Inserting a Node Into a Sorted Doubly Linked List – HackerRank](https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem)