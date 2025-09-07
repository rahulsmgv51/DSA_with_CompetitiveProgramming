package LinkedList.ConvertBinaryNumberInALinkedListToInteger;

public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        ListNode head = new ListNode(1); ListNode n2 = new ListNode(0); ListNode n3 = new ListNode(1); ListNode n4 = new ListNode(1);
        head.next = n2; n2.next = n3; n3.next = n4;
        Solution obj = new Solution();
        obj.printLL(head);
        // head = obj.reverseLL(head);
        obj.printLL(head);
        System.out.println( obj.getDecimalValue(head));
    }

}

class Solution {
    public int getDecimalValue(ListNode head) {
        
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
        
       /*  if (head == null)
            return 0;
        
        int count = countLL(head);
        System.out.println("ListNode Len: "+ count);
        int sum = 0;
        for (int i = count; i >= 0; i--) {
            sum = sum + (head.val * ((int) Math.pow(2, i)));
        }
        return sum; */
    }

    public ListNode reverseLL(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public int countLL(ListNode head) {
        int count = -1;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public void printLL(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val+" ");
            temp = temp.next;
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