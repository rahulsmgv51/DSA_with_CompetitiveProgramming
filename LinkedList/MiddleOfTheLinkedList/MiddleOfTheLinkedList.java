package LinkedList.MiddleOfTheLinkedList;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Node head = new Node(5);
        Node n1 = new Node(12);
        Node n2 = new Node(14);
        Node n3 = new Node(17);
        Node n4 = new Node(19);
        Node n5 = new Node(20);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        printLL(head);
        // head = middleNode(head);
        // printLL(head);

    }

    public static Node middleNode(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node middleNode2(Node head) {
        Node tmpNode = head;
        int count = 0;
        while (tmpNode != null) {
            count++;
            tmpNode = tmpNode.next;
        }
        System.out.println("Length of Node : "+ count);
        int mid = count/2;
       
        tmpNode = head;
        for (int i = 0; i < mid; i++) {

            tmpNode = tmpNode.next;
        }
        return tmpNode;
    }

    public static void printLL(Node head) {
        Node tmpNode = head;
        while (tmpNode != null) {
            System.out.print(tmpNode.data + " -> ");
            tmpNode = tmpNode.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}