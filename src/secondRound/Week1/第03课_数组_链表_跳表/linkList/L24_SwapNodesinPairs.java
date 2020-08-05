package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

import java.util.HashMap;

public class L24_SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode te = new ListNode(1);
        te.next = new ListNode(2);
        te.next.next = new ListNode(3);
        te.next.next.next = new ListNode(4);
        ListNode re = swapPairs1(te);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    //自创的头插法，不够优美
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode last;
        ListNode temp;

        ListNode first = new ListNode();
        ListNode tail = first;

        while (pre != null) {
            last = pre.next;
            if (last != null) {
                temp = last.next;

                tail.next = last;
                last.next = null;
                tail = tail.next;
            } else {
                temp = null;

            }
            tail.next = pre;
            pre.next = null;
            tail = tail.next;

            pre = temp;

        }

        return first.next;
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode last = cur.next;
//        ListNode temp;
        while (cur != null && last != null) {
            pre.next = last;
            cur.next = last.next;
            last.next = cur;

            pre = cur;
            cur = pre.next;
            if (cur != null) {
                last = cur.next;
            }
        }

        return newHead.next;
    }

    //仿写并背诵的递归法
    public ListNode swapPairs4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode p = swapPairs4(temp.next);

        head.next = p;
        temp.next = head;
        return temp;
    }


    //参考  的递归法
    public ListNode swapPairs3(ListNode head) {
        //递归的终止条件
        if (head == null || head.next == null) {
            return head;
        }
        //假设链表是 1->2->3->4
        //这句就先保存节点2
        ListNode tmp = head.next;
        //继续递归，处理节点3->4
        //当递归结束返回后，就变成了4->3
        //于是head节点就指向了4，变成1->4->3
        ListNode p = swapPairs(tmp.next);
        head.next = p;
        //将2节点指向1
        tmp.next = head;
        return tmp;
    }

    //复习  交换指针法
    public ListNode swapPairs5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode temp = cur.next;
        while (cur != null && temp != null) {
            pre.next = temp;
            cur.next = temp.next;
            temp.next = cur;

            pre = cur;
            cur = cur.next;
            if (cur != null) {
                temp = cur.next;
            }
        }
        return newHead.next;
    }

    //复习递归法
    public ListNode swapPairs6(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode p = swapPairs6(temp.next);

        temp.next = head;
        head.next = p;


        return temp;
    }

}

