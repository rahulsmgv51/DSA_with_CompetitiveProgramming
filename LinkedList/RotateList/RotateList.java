package LinkedList.RotateList;

public class RotateList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2));
        printList(head);
        head = rotateRight(head, 1);
        printList(head);
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

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;

        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }

        k = k % len;
        tail.next = head;

        ListNode newLastNode = findLastNode(head, len - k);

        head = newLastNode.next;
        newLastNode.next = null;

        return head;

    }

    public static ListNode findLastNode(ListNode temp, int k) {
        int count = 1;
        while (temp != null) {
            if (count == k)
                return temp;

            count++;
            temp = temp.next;
        }
        return temp;
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