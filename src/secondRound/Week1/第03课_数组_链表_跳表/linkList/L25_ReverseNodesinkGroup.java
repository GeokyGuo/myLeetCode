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

        ListNode re = reverseKGroup2(te, 1);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

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

    //基础版 反转链表法
    public static ListNode reverseKGroup1(ListNode head, int k) {
//        if (head == null) {
//            return head;
//        }
        ListNode newHead = new ListNode();

        ListNode pre = newHead;//上一轮的最后一个
        ListNode temp = head;//当前轮的第一个

        while (temp != null) {

            ListNode first = temp; //当前轮的第一个
            ListNode p = temp;
            for (int i = 1; i < k; i++) {
                if (p == null) {
                    break;
                } else {
                    p = p.next;
                }
            }
            if (p != null) {
                temp = p.next; //下一组的第一个
                p.next = null;
                ListNode re = getReviseList(first);
                pre.next = re;
                pre = first;//当前组的最后一个
            } else {
                pre.next = first;
                temp = null;
            }
        }
        return newHead.next;
    }

    public static ListNode getReviseList(ListNode first) {

        if (first == null) {
            return first;
        }

        ListNode pre = null;
        ListNode cur = first;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    //复习
    public static ListNode reverseKGroup2(ListNode head, int k) {

        ListNode newHead = new ListNode();
        ListNode pre = newHead;

        ListNode curKgroupFirst = head;
        ListNode curKgroupLast = getCurKgroupLast(curKgroupFirst, k);

        ListNode temp;

        while (curKgroupFirst != null && curKgroupLast != null) {
            temp = curKgroupLast.next;

            pre.next = curKgroupLast;

            curKgroupLast.next = null;
            reverse2(curKgroupFirst);

            curKgroupFirst.next = temp;


            pre = curKgroupFirst;

            curKgroupFirst = curKgroupFirst.next;
            curKgroupLast = getCurKgroupLast(curKgroupFirst, k);


        }
        pre.next = curKgroupFirst;

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
        if (first == null) {
            return null;
        }
        ListNode reNode = first;
        while (k > 1) {
            reNode = reNode.next;
            k--;
            if (reNode == null) {
                return null;
            }
        }
        return reNode;
    }


}


