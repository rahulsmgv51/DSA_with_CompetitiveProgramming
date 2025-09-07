package LinkedList.PartitionList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PartitionList {
    public static void main(String[] args) {
        int[] values = { 1, 4, 3, 2, 5, 2 };
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        printList(head);
        printList(partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode beforeList = new ListNode(-1);
        ListNode beforeTail = beforeList;

        ListNode afterList = null;
        ListNode afterTail = null;

        while (head != null) {
            ListNode tmp = new ListNode(head.val);
            if (head.val < x) {
                beforeTail.next = tmp;
                beforeTail = tmp;
            } else {
                if (afterList == null) {
                    afterList = tmp;
                } else {
                    afterTail.next = tmp;
                }
                afterTail = tmp;
            }
            head = head.next;
        }

        beforeTail.next = afterList;
        beforeTail = afterList;
        return beforeList.next;

    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}