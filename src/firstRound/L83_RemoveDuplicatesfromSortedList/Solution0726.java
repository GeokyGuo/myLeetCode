package firstRound.L83_RemoveDuplicatesfromSortedList;


import util.ListNode;

public class Solution0726 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);

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
        ListNode l = head;
        ListNode last = l;

        head = head.next;
        last.next = null;

        while (head != null) {
            if (head.val != last.val) {
                last.next = head;
                last = head;      //先接上，接上之后，两个都后移一个，最后断尾！
                head = head.next;
                last.next = null;
            } else {
                head = head.next;
                //31、31   31  这种结构，可以考虑给35行也加上32行这种冗余代码，就不需要else这个分支了
            }


        }
        return l;
    }

}