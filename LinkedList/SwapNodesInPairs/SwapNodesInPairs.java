package LinkedList.SwapNodesInPairs;

public class SwapNodesInPairs{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);

        printList(head);
        // swapPairs(head); //Iterative Solution
        swapPairs_R(head); //Recursive Solution
        printList(head);

    }

    public static ListNode swapPairs_R(ListNode head) {
        if(head == null || head.next == null) return head;

        // A = head
        // B = head.next
        // C = head.next.next

        ListNode tmp = head.next;
        head.next = swapPairs_R(head.next.next);
        tmp.next = head;

        return tmp;
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null) return head;

        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.val != curr.next.val){
                int tmp = curr.next.val;
                curr.next.val = curr.val;
                curr.val = tmp;
            }
            if(curr.next.next != null){
                curr = curr.next.next;
            }
            else{
                break;
            }
        }

        return head;
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
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}