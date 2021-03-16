package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class L25_ReverseNodesinkGroup {
    public static void main(String[] args) {
        ListNode te = new ListNode(1);
        te.next = new ListNode(2);
        te.next.next = new ListNode(3);
        te.next.next.next = new ListNode(4);
        te.next.next.next.next = new ListNode(5);

        ListNode re = reverseKGroup2(te, 3);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }
//----------------------------------------
    //自己想的双端队列，
    public static ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> deque = new LinkedList();
        ListNode p = head;

        ListNode last = new ListNode();
        ListNode q = last;
        while (p != null) {
            int flag = 0;
            for (int i = 0; i < k; i++) {
                if (p != null) {
                    deque.offerLast(p);
                    p = p.next;
                } else {
                    flag = 1;//未满k个
                    break;
                }
            }

            ListNode first = new ListNode();
            ListNode tail = first;
            ListNode temp;
            while (true) {
                if (flag == 0) {
                    temp = deque.pollLast();
                } else {
                    temp = deque.pollFirst();
                }
                if (temp == null) {
                    break;
                }
                tail.next = temp;
                temp.next = null;
                tail = temp;
            }
            last.next = first.next;
            last = tail;
        }
        return q.next;
    }
//----------------------------------------



    //----------------------------------------
    //复习 ---改造过的  kgroup中的尾，可以不重复获取
    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode newHead = new ListNode();
        ListNode pre = newHead;

        ListNode curKgroupFirst = head;
//        ListNode curKgroupLast = getCurKgroupLast(curKgroupFirst, k);
        ListNode curKgroupLast;
        ListNode temp;

        while (curKgroupFirst != null) {
            curKgroupLast = getCurKgroupLast(curKgroupFirst, k);
            if (curKgroupLast == null) break;
            temp = curKgroupLast.next;

            pre.next = curKgroupLast;

            curKgroupLast.next = null;
            reverse2(curKgroupFirst);

            curKgroupFirst.next = temp;


            pre = curKgroupFirst;
            curKgroupFirst = curKgroupFirst.next;

        }

        // 不需要这一句
//        pre.next = curKgroupFirst;

        return newHead.next;
    }

    public static void reverse2(ListNode first) {
        ListNode pre = null;
        ListNode cur = first;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

    }

    public static ListNode getCurKgroupLast(ListNode first, int k) {
        ListNode cur = first;
        int i = 0;
        while(i < (k - 1)){
            if(cur == null){
                return null;
            }
            cur = cur.next;
            i++;
        }
        return cur;
    }



}


