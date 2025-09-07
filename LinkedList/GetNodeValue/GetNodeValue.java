package LinkedList.GetNodeValue;

import java.util.Scanner;

public class GetNodeValue {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            SinglyLinkedListNode head = null;
            SinglyLinkedListNode tail = null;
            for (int i = 0; i < n; i++) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(scn.nextInt());
                if (head == null) {
                    head = tmp;
                } else {
                    tail.next = tmp;
                }
                tail = tmp;
            }
            int pos = scn.nextInt();
            // printList(head);
            System.out.println(getNode(head, pos));
        }
    }

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        if(llist.next == null){
            return llist.data;
        }
        int count = 0;
        SinglyLinkedListNode tmpC = llist;
        while (tmpC != null) {
            count++;
            tmpC = tmpC.next;
        }
        // System.out.println("Size : "+count);
        for (int i = 0; i <(count-positionFromTail)-1; i++) {
            llist = llist.next;
        }
        return llist.data;
    }

    public static void printList(SinglyLinkedListNode head) {
        SinglyLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
            if (node != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}