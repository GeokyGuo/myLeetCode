package L83_RemoveDuplicatesfromSortedList;


import static L83_RemoveDuplicatesfromSortedList.Solution.deleteDuplicates1;

public class Solution0722 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

        ListNode re = deleteDuplicates1(head);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head.next;
        ListNode pre = head;

        while (p != null) {
            if (p.val == pre.val) {
                pre.next = p.next;
                p.next = null;  //清空野指针
                p = pre.next;
            } else {
                pre = p;
                p = p.next;
            }

        }
        return head;
    }

    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode newhead = new ListNode(-100);
        ListNode last = newhead;

        ListNode p = head;
        while (p != null) {
            if (p.val != last.val) {
                last.next = p;
                last = p;
            }
            p = p.next;
            last.next = null;
        }

        return newhead.next;
    }
}