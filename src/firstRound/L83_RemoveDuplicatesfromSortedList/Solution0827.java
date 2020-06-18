package firstRound.L83_RemoveDuplicatesfromSortedList;


import util.ListNode;

public class Solution0827 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(4);

        ListNode re = deleteDuplicates(head);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head.next;
        ListNode last = head;
        last.next = null; // 断链1

        while (p != null) {
            if (p.val != last.val) {
                last.next = p;
                last = p;
                p = p.next;
                last.next = null;// 断链2
            } else {
                p = p.next;
            }
        }

        return head;
    }
}