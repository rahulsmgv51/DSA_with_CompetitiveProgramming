package LinkedList.RemoveDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList1 {
    public static void main(String[] args){
        // Create nodes
        ListNode head = new ListNode(-1), node2 = new ListNode(-1), node3 = new ListNode(2), node4 = new ListNode(2), node5 = new ListNode(3), node6 = new ListNode(3), node7 = new ListNode(3);
        // Connect nodes
        head.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6; node6.next = node7;
        Solution obj = new Solution();
        obj.printLL(head);
        obj.deleteDuplicates(head);
        obj.printLL(head);
    }
}

class ListNode {
    int val;
	ListNode next;
	ListNode() { val = 0; next = null; }
	ListNode(int val) { this.val = val; next = null; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public void printLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}