package firstRound.L21_MergeTwoSortedLists;


import util.ListNode;

public class Solution0918 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode re = mergeTwoLists(l1, l2);

        for (; re != null; re = re.next) {
            System.out.println(re.val);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(1);
        ListNode last = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                last = l1;
                l1 = l1.next;
                last.next = null;
            } else {
                last.next = l2;
                last = l2;
                l2 = l2.next;
                last.next = null;
            }

        }

        if (l1 != null) {
            last.next = l1;
        }
        if (l2 != null) {
            last.next = l2;
        }


        return head.next;
    }

}
