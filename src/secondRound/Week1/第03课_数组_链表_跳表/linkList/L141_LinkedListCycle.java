package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

import java.util.HashMap;

public class L141_LinkedListCycle {
    public static void main(String[] args) {


    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            int pos = -1;
            return false;
        }
        int i = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p)) {
                int pos = map.get(p);
                return true;
            } else {
                map.put(p, i);
                p = p.next;
            }
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return true;
    }

    //复习
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {  //如果不好判断什么时候退出，就直接写true，在循环中判断 break或return
            slow = slow.next;                        // 最好把这个判断写进 循环中，因为 fast为空本身也是一种要return的情况，如果后续还有处理，的话 不能确定是fast为null退出了循环，还是，slow ==fast 退出了循环
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


}
