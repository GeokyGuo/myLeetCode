package firstRound.L21_MergeTwoSortedLists;


import util.ListNode;

public class Solution {
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
        ListNode i1 = l1;//扫描指针
        ListNode i2 = l2;
        ListNode i3 = new ListNode(-1);//头结点
        ListNode isla = i3;//尾指针
        while (i1 != null && i2 != null) {
            if (i1.val < i2.val) {
                isla.next = i1;
                isla = i1;
                i1 = i1.next;
            } else {
                isla.next = i2;
                isla = i2;
                i2 = i2.next;
            }
        }
        if (i1 != null) {
            isla.next = i1;
        }
        if (i2 != null) {
            isla.next = i2;
        }
        return i3.next;
    }
}
