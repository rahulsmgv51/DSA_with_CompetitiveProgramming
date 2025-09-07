package LinkedList.ReorderList;

public class ReorderList {
    public static void main(String[] args){
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        new Solution().reorderList(head);
        new Solution().printLL(head);
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode() { val = 0; next = null; }
	ListNode(int val) { this.val = val; next = null; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
	public void reorderList(ListNode head) {
    if(head == null) return;

    ListNode slow = head;
    ListNode fast = head;
    ListNode curr = head;
    ListNode currTail = null;

    while(fast != null && fast.next != null){
      currTail = slow;
      slow = slow.next;
      fast = (fast.next).next;
    }
    currTail.next = null;
    System.out.println("Mid Element "+slow.val);

    ListNode rCurr = reverseLL(slow);

    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;
    // System.out.print("ListNode L1 : ");
    // printLL(curr);
    // System.out.print("ListNode L2 : ");
    // printLL(rCurr);


    while(curr != null && rCurr != null){
        tail.next = curr;
        tail = curr;
        curr = curr.next;
        tail.next = rCurr;
        tail = rCurr;
        rCurr = rCurr.next;
    }
    if(curr != null){
      tail.next = curr;
      tail = curr;
    }

    if(rCurr != null){
      tail.next = rCurr;
      tail = rCurr;
    }
	}

  public void printLL(ListNode head){
    while(head != null){
      System.out.print(head.val);
      if(head.next != null){
        System.out.print(" ");
      }

      head = head.next;
    }

    System.out.println();
  }

  public ListNode reverseLL(ListNode head){
    if(head == null || head.next == null)return head;
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
}