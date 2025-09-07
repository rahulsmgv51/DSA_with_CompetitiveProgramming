package LinkedList.SortBinaryLinkedList;

public class SortBinaryLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(0));
        
        printList(head);
        head = sortBinaryList(head);
        printList(head);

    }

    public static ListNode sortBinaryList(ListNode A) {
        if (A == null || A.next == null)
            return A;

        ListNode head1 = null;
        ListNode head2 = null;
        ListNode tail1 = null;
        ListNode tail2 = null;

        while (A != null) {
            if (A.val == 0) {
                if (head1 == null) {
                    head1 = tail1 = A;
                } else {
                    tail1.next = A;
                }
                tail1 = A;
            } else {
                if (head2 == null) {
                    head2 = tail2 = A;
                } else {
                    tail2.next = A;
                }
                tail2 = A;
            }
            A = A.next;
        }

        if(tail2 != null)tail2.next = null;
        if(tail1 != null)tail1.next = head2;

        return head1;

    }
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}