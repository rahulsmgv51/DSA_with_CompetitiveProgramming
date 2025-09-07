package LinkedList.MyListNode;

public class MyListNode {
    public static void main(String[] args){
        ListNode head = new ListNode(10); ListNode n2 = new ListNode(20); ListNode n3 = new ListNode(30); ListNode n4 = new ListNode(40); ListNode n5 = new ListNode(50); ListNode n6 = new ListNode(60);
        head.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
        
        MyListNode obj = new MyListNode();
        obj.printLL(head);
        System.out.println(obj.sizeLL(head));
        head = obj.insertInLL(3, 70, head);
        obj.printLL(head);
        head = obj.deleteLL(6, head);
        obj.printLL(head);
    }

    public ListNode deleteLL(int pos, ListNode head) {
        if (head == null) return null;
        if (pos == 0) return head.next;
        ListNode tmpNode = head;
        for (int i = 0; i < pos - 1 && tmpNode != null && tmpNode.next != null; i++) {
            tmpNode = tmpNode.next;
        }
        if (tmpNode == null || tmpNode.next == null) {
            System.out.println("Position out of bounds");
            return head;
        }
        tmpNode.next = tmpNode.next.next;
        return head;
    }

    public ListNode insertInLL(int pos, int val, ListNode head) {
        ListNode newNode = new ListNode(val);
        if (pos == 0) {
            newNode.next = head;
            return newNode;
        }
        ListNode tmpNode = head;
        for (int i = 0; i < pos - 1 && tmpNode != null; i++) {
            tmpNode = tmpNode.next;
        }
        if (tmpNode == null) {
            System.out.println("Reached end of LinkedList");
            return head;
        }
        newNode.next = tmpNode.next;
        tmpNode.next = newNode;
        return head;
    }

    public int sizeLL(ListNode head) {
        int count = 0;
        for (ListNode tmpNode = head; tmpNode != null; tmpNode = tmpNode.next) {
            count++;
        }
        return count;
    }

    public void printLL(ListNode head) {
        for (ListNode tmpNode = head; tmpNode != null; tmpNode = tmpNode.next) {
            System.out.print(tmpNode.val);
            if (tmpNode.next != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}