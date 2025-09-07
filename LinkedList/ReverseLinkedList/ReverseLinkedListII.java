package LinkedList.ReverseLinkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        SolutionII obj = new SolutionII();
        obj.printLL(head);
        head = obj.reverseListII(head, 2, 3);
        obj.printLL(head);
    }
}

class SolutionII {
    public ListNode reverseListII(ListNode head, int left, int right) {
        ListNode ptrNode = new ListNode(-1);
        ptrNode.next = head;

        ListNode prev = ptrNode;

        for(int i=1; i<left; i++){
            prev = prev.next;
        }

        ListNode curr = prev.next;
        for(int i=1; i<= right-left; i++){
            ListNode tmp = prev.next; 
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = tmp;
        }

        return ptrNode.next;

    }

    public void printLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null)
                System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
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