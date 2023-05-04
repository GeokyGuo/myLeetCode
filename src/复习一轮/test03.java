package 复习一轮;


import util.ListNode;

public class test03 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseKGroup(head, 2);
    }

    //142 环形快慢指针//todo
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //206
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp = null;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //206 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode listNode = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    //24 递归法
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = swapPairs(head.next.next);
        head.next.next = head;
        ListNode p = head.next;
        head.next = listNode;
        return p;
    }

    //24 指针交换法
    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode last;
        ListNode temp;

        while (cur != null) {
            last = cur.next;
            if (last == null) break;

            temp = last.next;


            pre.next = last; //todo
            last.next = cur;
            cur.next = temp;

            pre = cur;
            cur = temp;


        }

        return newHead.next;
    }

    //25
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();

        ListNode pre = newHead;
        ListNode kGroupFirst = head;

        ListNode kGroupLast;
        ListNode temp;
        while (kGroupFirst != null) {
            kGroupLast = getKgroupLast(kGroupFirst, k);
            if (kGroupLast == null) break;

            temp = kGroupLast.next;

            pre.next = kGroupLast;
            kGroupLast.next = null;
            reverseKListNode(kGroupFirst);
            kGroupFirst.next = temp;

            pre = kGroupFirst;
            kGroupFirst = temp;
        }
        return newHead.next;
    }

    public static void reverseKListNode(ListNode kGroupFirst) {
        ListNode pre = null;
        ListNode cur = kGroupFirst;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }

    public static ListNode getKgroupLast(ListNode head, int k) {
        ListNode cur = head;
        int i = 1;
        while (i < k) {
            if (cur == null) {
                return null;
            }
            cur = cur.next;
            i++;
        }

        return cur;
    }


}