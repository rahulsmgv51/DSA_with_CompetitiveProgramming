package LinkedList.RemoveDuplicatesFromSortedList.DeleteDuplicateValueNodesFromASortedLinkedList;

import java.util.Scanner;

public class DeleteDuplicateValueNodesFromASortedLinkedList {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            Node head = null;
            Node tail = null;
            for(int i=0; i<n; i++){
                Node tmp = new Node(scn.nextInt());
                if(head == null){
                    head = tmp;
                }else{
                    tail.next = tmp;
                }
                tail = tmp;
            }
            printLL(head);
            head = removeDuplicates(head);
            printLL(head);
        }
    }
    public static Node removeDuplicates(Node head){
        if(head.next == null) return head;
        Node newHead = null;
        Node curr = head;
        Node tail = null;
        while(curr != null){
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next;
            }
            if(newHead == null){
                newHead = curr;
            }
            else{
                tail.next = curr;
            }
            tail = curr;
            curr = curr.next;
        }

        return newHead;
    }

    public static void printLL(Node head){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}