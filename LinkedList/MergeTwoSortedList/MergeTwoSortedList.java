package LinkedList.MergeTwoSortedList;

public class MergeTwoSortedList {
    public static void main(String args[]){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        printLL(list1); printLL(list2);
        ListNode head = mergeTwoLists(list1, list2);
        printLL(head);

    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode head = null, tail = null;
        while(list1 != null && list2 != null){
            ListNode tmp = null;
            if(list1.val < list2.val){
                tmp = list1;
                list1 = list1.next;
            }
            else{
                tmp = list2;
                list2 = list2.next;
            }
            tmp.next = null;
            if(head == null){
                head = tail = tmp;
            }else{
                tail.next = tmp;
                tail = tmp;
            }
        }

        if(list1 == null){
            tail.next = list2;
        }
        if(list2 == null){
            tail.next = list1;
        }

        return head;
    }

    public static void printLL(ListNode head) {
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
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}