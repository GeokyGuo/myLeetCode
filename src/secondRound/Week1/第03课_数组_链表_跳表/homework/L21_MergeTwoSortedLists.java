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
        ListNode re = mergeTwoLists1(l1, l2);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
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

    //复习 指针法--精简
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode rear = newHead;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                rear.next = l1;
                l1 = l1.next;
            }else{
                rear.next = l2;
                l2 = l2.next;
            }
            rear = rear.next;
            rear.next = null;
        }

        rear.next = l1 !=null? l1 : l2;
        return newHead.next;

    }

}
