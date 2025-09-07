package LinkedList.IntersectionOfTwoLinkedLists;

import java.util.Scanner;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- > 0){
            // Read list sizes
            int n1 = scn.nextInt();
            int n2 = scn.nextInt();
            int interPos = scn.nextInt(); // position where intersection starts (1-based, 0 if no intersection)

            // Build first list
            ListNode headA = null, tailA = null;
            for(int i = 0; i < n1; i++) {
                int val = scn.nextInt();
                ListNode node = new ListNode(val);
                if(headA == null) {
                    headA = node;
                } else {
                    tailA.next = node;
                }
                tailA = node;
            }

            // Build second list
            ListNode headB = null, tailB = null;
            for(int i = 0; i < n2; i++) {
                int val = scn.nextInt();
                ListNode node = new ListNode(val);
                if(headB == null) {
                    headB = node;
                } else {
                    tailB.next = node;
                }
                tailB = node;
            }

            // If intersection exists, link tail of B to intersection node in A
            if(interPos > 0) {
                ListNode interNode = headA;
                for(int i = 1; i < interPos; i++) {
                    if(interNode != null) interNode = interNode.next;
                }
                if(tailB != null) tailB.next = interNode;
            }

            ListNode intersection = new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB);
            if(intersection != null) {
                System.out.println(intersection.val);
            } else {
                System.out.println("No Intersection");
            }
        }
        scn.close();
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null){
            return null;
        }
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        while(t1 != t2){
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }
        return t1;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}