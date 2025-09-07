package LinkedList.PalindromeLinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        head.next = n2; n2.next = n3; n3.next = n4;
        SolutionP objp = new SolutionP();
        objp.printLL(head);
        System.out.println(objp.isPalindrome(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class SolutionP {
    public boolean isPalindrome(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tmpNode = dummy.next;
        ListNode reverseHead = reverse(tmpNode);
        printLL(reverseHead);
        boolean isPalin = true;
        
        ListNode tmpRNode = reverseHead;
        while(tmpNode != null){
            System.out.println(tmpNode.val+ " <--> "+tmpRNode.val);
            if(tmpNode.val == tmpRNode.val){
                tmpNode = tmpNode.next;
                tmpRNode = tmpRNode.next;
            }
            else{
                isPalin = false;
                break;
            }
        }
        return isPalin;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = new ListNode(curr.val);
            curr = tmp;
        }
        return prev;
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