package LinkedList.RemoveNthNodeFromEndOfList;
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        // Create ListNode using 1 2 3 4 5
        ListNode head = new ListNode(1,
                            new ListNode(2,
                                new ListNode(3,
                                    new ListNode(4,
                                        new ListNode(5)))));

        printList(head);
        head = removeNthFromEnd(head, 9);
        printList(head);
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode dummy = new ListNode(-1);
        dummy.next = A;
        ListNode slow = dummy;
        ListNode fast = dummy;

        for(int i=0; i<=B; i++){
            if(fast == null)
                return A.next;

            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
	}

    // Print function for ListNode
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() { val = 0; next = null; }
    ListNode(int val) { this.val = val; next = null; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}