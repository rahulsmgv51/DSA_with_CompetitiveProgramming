package LinkedList.RemoveNodesFromLinkedList;

public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(5);

        // Linking nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printLL(n1);
        n1 = removeNodes(n1);
        printLL(n1);
    }

    public static ListNode removeNodes(ListNode head) {
        ListNode tmpNode = head;
        ListNode newNode = null;
        while(tmpNode.next != null){
            System.out.println(tmpNode.data+" < "+tmpNode.next.data);
            if(tmpNode.data < tmpNode.next.data){
                if(newNode == null){
                    newNode = tmpNode.next;
                }
                else{
                    newNode.next = tmpNode.next;
                }

            }
            tmpNode = tmpNode.next;
        }
        return newNode;
    }

    public static void printLL(ListNode head){
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}