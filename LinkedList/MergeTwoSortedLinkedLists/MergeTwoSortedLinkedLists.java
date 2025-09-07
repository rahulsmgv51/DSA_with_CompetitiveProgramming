package LinkedList.MergeTwoSortedLinkedLists;

import java.util.Scanner;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
           int n = scn.nextInt();
            SinglyLinkedListNode list1 = null;
            SinglyLinkedListNode tail = null;
            for (int i = 1; i <= n; i++) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(scn.nextInt());
                if (list1 == null) {
                    list1 = tmp;
                    tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
            }
            int m = scn.nextInt();
            SinglyLinkedListNode list2 = null;
            tail = null;
            for (int i = 1; i <= m; i++) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(scn.nextInt());
                if (list2 == null) {
                    list2 = tmp; 
                    tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
            }
            printLL(list1);printLL(list2);
            SinglyLinkedListNode mergeList = mergeLists(list1, list2);
            printLL(mergeList);
        }
    }

    public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode h1, SinglyLinkedListNode h2) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode tail = null;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(h1.val);
                if (head == null) {
                    head = tmp;
                    tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
                h1 = h1.next;
            } else {
                SinglyLinkedListNode tmp = new SinglyLinkedListNode(h2.val);
                if (head == null) {
                    head = tmp;
                    tail = tmp;
                } else {
                    tail.next = tmp;
                    tail = tmp;
                }
                h2 = h2.next;
            }
        }
        if (h1 != null) {
            tail.next = h1;
        }
        if (h2 != null) {
            tail.next = h2;
        }

        return head;
    }

    public static void printLL(SinglyLinkedListNode head) {
        for (SinglyLinkedListNode tmpNode = head; tmpNode != null; tmpNode = tmpNode.next) {
            System.out.print(tmpNode.val);
            if (tmpNode.next != null) {
                System.out.print(" -> ");
            }
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