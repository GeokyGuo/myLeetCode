package L21_MergeTwoSortedLists;


public class Solution0709 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode re = mergeTwoLists(l1, l2);

        for (; re != null; re = re.next) {
            System.out.println(re.val);
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        ListNode head = new ListNode(-1);
        ListNode last = head;

        while (ll1 != null && ll2 != null) {
            if (ll1.val < ll2.val) {
                last.next = ll1;
                last = ll1;
                ll1 = ll1.next;
            } else {
                last.next = ll2;
                last = ll2;
                ll2 = ll2.next;
            }
        }
        if (ll1 != null) {
            last.next = ll1;
        }
        if (ll2 != null) {
            last.next = ll2;
        }

        return head.next;
    }
}
