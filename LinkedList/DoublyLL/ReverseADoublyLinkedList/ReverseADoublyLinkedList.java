package LinkedList.DoublyLL.ReverseADoublyLinkedList;

import java.util.Scanner;

public class ReverseADoublyLinkedList {
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            DoublyLinkedListNode head = null;
            DoublyLinkedListNode tail = null;
            for(int i=0; i<n; i++){
                DoublyLinkedListNode tmp = new DoublyLinkedListNode(scn.nextInt());
                if(head == null){
                    head = tail = tmp;
                }else{
                    tail.next = tmp;
                    tmp.prev = tail;
                    tail = tmp;
                }
            }

        }
    }

    public static DoublyLinkedListNode reverse(DoublyLinkedListNode llist) {
        DoublyLinkedListNode curr = llist;
        DoublyLinkedListNode tail = null;
        while(curr != null){
            DoublyLinkedListNode tmp = curr.next;
            curr.next = tail;
            tail = curr;
            curr = tmp;
        }

        return tail;
    }

    public static void printLL(DoublyLinkedListNode llist) {
        for (DoublyLinkedListNode tmp = llist; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.data + " ");
        }
        System.out.println();
    }
}

class DoublyLinkedListNode{
    int data;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}