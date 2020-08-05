package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

public class L206_ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode re = reverseList(head);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    //自创的头插法，不优美
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode();

        ListNode last = head.next;

        while (head != null) {
            head.next = null;
            head.next = first.next;
            first.next = head;
            head = last;
            if (last != null) {

                last = last.next;
            }
        }
        return first.next;
    }


//其他优秀方法：  递归法，  三指针 法    而且头插发还可以改进

    //改进的头插法，用了临时变量
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode();
        ListNode p = head;
        ListNode temp;
        while (p != null) {
            temp = p.next;
            p.next = first.next;
            first.next = p;
            p = temp;
        }
        return first.next;
    }

    //三指针法，也就是两两交换法
    public static ListNode reverseList2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归法
    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList3(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }

    //复习 指针法
    public static ListNode reverseList4(ListNode head) {
        if (head == null) {
            return head;
        }
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

    //复习 头插法
    public static ListNode reverseList5(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode p = head;
        ListNode temp;
        while (p != null) {
            temp = p.next;

            p.next = newHead.next;
            newHead.next = p;
            p = temp;
        }
        return newHead.next;
    }

    //复习 递归
    public static ListNode reverseList6(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList6(head.next);

        head.next.next = head;
        head.next = null;


        return p;
    }

}



