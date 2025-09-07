package LinkedList.CompareTwoList;

import java.io.*;
import java.util.*;

public class CompareTwoList {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            SinglyLinkedListNode list1 = null;
            for (int i = 1; i <= n; i++) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(scn.nextInt());
                if (list1 == null) {
                    list1 = tmp;
                } else {
                    list1.next = tmp;
                }
            }
            int m = scn.nextInt();
            SinglyLinkedListNode list2 = null;
            for (int i = 1; i <= m; i++) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(scn.nextInt());
                if (list2 == null) {
                    list2 = tmp;
                } else {
                    list2.next = tmp;
                }
            }
            printLinkedList(list1);
            printLinkedList(list2);
            System.out.println(compare_lists(list1, list2));
        }

        
    }

    public static int compare_lists (SinglyLinkedListNode h1, SinglyLinkedListNode h2){
        while(h1 != null && h2 != null){
            if(h1.val != h2.val){
                return 0;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        if(h1 != null){
            return 0;
        }
        if(h2 != null){
            return 0;
        }
        return 1;
    }

    public static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ->");
            curr = curr.next;
        }
        System.out.println();
    }

}

class SinglyLinkedListNode {
    int val;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
}