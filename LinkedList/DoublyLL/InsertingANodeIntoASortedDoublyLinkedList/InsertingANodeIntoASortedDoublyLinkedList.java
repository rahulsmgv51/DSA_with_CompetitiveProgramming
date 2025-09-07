package LinkedList.DoublyLL.InsertingANodeIntoASortedDoublyLinkedList;

import java.util.Scanner;

public class InsertingANodeIntoASortedDoublyLinkedList {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            int n = scn.nextInt();
            DoubleNodeLL head = null;
            DoubleNodeLL tail = null;
            for(int i=1; i<=n; i++){
                DoubleNodeLL tmp = new DoubleNodeLL(scn.nextInt());
                if(head == null){
                    head = tail = tmp;
                }
                else{
                    tail.next = tmp;
                    tmp.prev = tail;
                    tail = tmp;
                }
            }
            int data = scn.nextInt();
            printDLLF(head);
            printDLLB(tail);

        }
    }

    public static DoubleNodeLL sortedInsert(DoubleNodeLL head, int newVal){
        DoubleNodeLL tmp = head;
        DoubleNodeLL newNode = new DoubleNodeLL(newVal);
        if(head == null) return newNode;

        if(newVal < head.data){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }

        while(newVal > tmp.data){
            if(tmp.next == null){
                tmp.next = newNode;
                newNode.prev = tmp;
                return head;
            }
            tmp = tmp.next;
        }
        newNode.prev = tmp.prev;
        tmp.prev.next = newNode;
        newNode.next = tmp;
        tmp.prev = newNode;

        return head;
    }

    public static void printDLLF(DoubleNodeLL head){
        DoubleNodeLL tmp = head;
        while(tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void printDLLB(DoubleNodeLL tail){
        DoubleNodeLL tmp = tail;
        while(tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.prev;
        }
        System.out.println();
    }

}

class DoubleNodeLL{
    int data;
    DoubleNodeLL next;
    DoubleNodeLL prev;

    public DoubleNodeLL(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}