package firstRound.L21_MergeTwoSortedLists;

/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

        Example:

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4*/


import util.ListNode;

public class Solution0724 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(9);

        ListNode re = mergeTwoLists1(l1, l2);

        for (; re != null; re = re.next) {
            System.out.println(re.val);
        }
    }

    /**
     * 穿针引线法
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {  //新链表的表头的表尾要用新的，就的扫描指针可以不用新建
        ListNode head = new ListNode(-1);
        ListNode last = head;
        ListNode l1p = l1;
        ListNode l2p = l2;

        while (l1p != null && l2p != null) {
            if (l1p.val < l2p.val) {
                last.next = l1p;
                last = l1p;
                l1p = l1p.next;
                last.next = null;//注意清扫尾指针、以及野指针
            } else {
                last.next = l2p;
                last = l2p;
                l2p = l2p.next;
                last.next = null;  //注意清扫尾指针、以及野指针
            }
        }

        if (l1p != null) {
            last.next = l1p;
        }
        if (l2p != null) {
            last.next = l2p;
        }

        return head.next;
    }


    /**
     * 递归法
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }
}
