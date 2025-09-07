package LinkedList.ReverseNodesInKGroup;

public class ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7)))))));

        printLL(head);
        head = reverseKGroup(head, 4);
        printLL(head);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevTail = dummy;
        ListNode currHead = head;

        while(currHead != null){
            ListNode currTail = currHead;
            for(int i=0; i<k-1; i++){
                if(currTail == null) break;
                currTail = currTail.next;
            }

            if(currTail == null) break;
            ListNode nextHead = currTail.next;
            reverseKTimes(currHead, k);

            prevTail.next = currTail;
            currHead.next = nextHead;
            prevTail = currHead;
            currHead = nextHead;
        }

        prevTail.next = currHead;

        // prevTail.next = reverseKTimes(currHead, k); // If want to also reverse remaining than above comment and remove comment this line.

        return dummy.next;
    }

    public static ListNode reverseKTimes(ListNode head, int k){
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        int count = 0;
        while(curr != null && count < k){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
            count++;
        }
        return prev;
    }

    public static void printLL(ListNode head){
        ListNode tmp = head;
        while(tmp != null){
            System.out.print(tmp.val);
            if(tmp.next != null) System.out.print(" -> ");
            tmp = tmp.next;
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