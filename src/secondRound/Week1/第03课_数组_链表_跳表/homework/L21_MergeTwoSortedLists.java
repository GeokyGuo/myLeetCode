package secondRound.Week1.第03课_数组_链表_跳表.homework;

import util.ListNode;

import java.util.List;

public class L21_MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode re = mergeTwoLists(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    //自己一遍ac的穿针引线法   还有搬运了一个递归法，也比较有趣
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l1 == null) {
            return l1;
        }
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
                tail.next = null;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
                tail.next = null;
            }

        }
        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }

        return newHead.next;
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

    //复习 递归法
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    //复习 指针法
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode rear = newHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                rear.next = p1;
                rear = p1;
                p1 = p1.next;
                rear.next = null;
            } else {
                rear.next = p2;
                rear = p2;
                p2 = p2.next;
                rear.next = null;
            }
        }
        if (p1 != null) {
            rear.next = p1;
        }
        if (p2!=null) {
            rear.next = p2;
        }
        return newHead.next;
    }

}
