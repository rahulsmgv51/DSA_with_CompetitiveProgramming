package LinkedList.RemoveDuplicatesFromSortedList;

public class RemoveDuplicatesFromSortedList {
    public static void main(String args[]) {
        // Create nodes
        ListNode node1 = new ListNode(1), node2 = new ListNode(2), node3 = new ListNode(3), node4 = new ListNode(3), node5 = new ListNode(4), node6 = new ListNode(4), node7 = new ListNode(5);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6; node6.next = node7;
        printLL(node1);
        deleteDuplicates(node1);
        printLL(node1);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tmpNode = head;
        while(tmpNode != null && tmpNode.next != null){
            System.out.println("tmpNode.val : "+tmpNode.val+" tmpNode.next.val : "+ tmpNode.next.val);
            if(tmpNode.val == tmpNode.next.val){
                tmpNode.next = tmpNode.next.next;
            }
            else{
                tmpNode = tmpNode.next;
            }
        }
        return head;
    }

    public static void printLL(ListNode head) {
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

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
