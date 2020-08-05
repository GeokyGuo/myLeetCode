package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

public class L142_LinkedListCycleII {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = first.next;

        ListNode re = detectCycle5(first);

        System.out.println(re.val);

//        ListNode re1 = getdupNode(first);
//
//        System.out.println(re1.val);


    }

    public static ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode dul = getdupNode(head);

        if (dul == null) {
            return null;
        }
        while (p != dul) {
            p = p.next;
            dul = dul.next;
        }
        return p;
    }

    public static ListNode getdupNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
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
        return slow;
    }

    //参考
    public ListNode detectCycle3(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    //两种方法  快慢指针和  hash法

//第一次相遇时慢指针已经走了nb步  快指针走了f = 2nb   f = 2s    f = s + nb
//走a+nb步一定是在环入口

    //复习
    public ListNode detectCycle4(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {  //即这里要写进循环中，不然判断不出从哪里退出了循环
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
        return fast;
    }

    //复习
    public static ListNode detectCycle5(ListNode head) {
        if (head == null) return head;
        ListNode s = head;
        ListNode f = head;

        do {
            if (f == null || f.next == null) {       //第一次起点一样，要先变化指针  用do while
                return null;
            }
            s = s.next;
            f = f.next.next;
        } while (s != f);

        f = head;

        while (s != f) {      //第二次起点一可能就是 最后的返回点，要先判断
            f = f.next;
            s = s.next;
        }
        return f;
    }

}

