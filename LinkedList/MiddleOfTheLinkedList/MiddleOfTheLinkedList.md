### Middle of the Linked List
* Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

![alt text](image.png)

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:

![alt text](image-1.png)

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100


### Solution
1. Take two pointer slow and fast, initailze with head node.
2. Slow pointer move one step and fast pointer move two step at a time.
3. check fast point to not be null or fast.next pointer to not be null.
4. return slow.