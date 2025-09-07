package LinkedList.MergeKSortedLists;

public class MergeKSortedLists {
    public static void main(String[] args){
        // ListNode[] lists = { new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6)) };
        // ListNode[] lists = { new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(7)))), new ListNode(2, new ListNode(4, new ListNode(6, new ListNode(8)))), new ListNode(0, new ListNode(9, new ListNode(10, new ListNode(11)))) };
        // ListNode[] lists = { null, new ListNode(1), null,  new ListNode(2)};
        ListNode[] lists = { null, null, null };

        for(int i=0; i<lists.length; i++){
            printLL(lists[i]);
        }
        ListNode head = mergeKLists(lists);
        printLL(head);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        int  count = 1;
        ListNode head = null;
        for(int j=0; j<lists.length; j++){
            if(lists[j] == null){
                count++;
            } 
            else if(lists[j] != null){
                head = lists[count-1];
                break;
            } 
        }

        for(int i=count; i<lists.length; i++){
            if(lists[i] == null){
                continue;
            }
            ListNode newList = lists[i];
            ListNode currList = head;
            ListNode newHead = null;
            ListNode tail = null;
            while(currList != null && newList != null){
                if(currList.val < newList.val){
                    if(newHead == null){
                        newHead = currList;
                    }else{
                        tail.next = currList;
                    }
                    tail = currList;
                    currList = currList.next;
                }
                else{
                    if(newHead == null){
                        newHead = newList;
                    }else{
                        tail.next = newList;
                    }
                    tail = newList;
                    newList = newList.next;
                }
            }
            if(currList != null){
                tail.next = currList;
                tail = currList;
            }
            
            if(newList != null){
                tail.next = newList;
                tail = newList;
            }
            head = newHead;
            tail = null;
        }

        return head;
    }

    public static void printLL(ListNode head) {
        for (ListNode curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}