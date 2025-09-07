package LinkedList.RemoveDuplicatesFromSortedList.RemoveDuplicatesFromSortedListII;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode head2 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));

        printList(head1);
        head1 = deleteDuplicates(head1);
        printList(head1);

        printList(head2);
        head2 = deleteDuplicates(head2);
        printList(head2);
    }

    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
                head = head.next;
            } else {
                prev = prev.next;
                head = head.next;
            }

        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}