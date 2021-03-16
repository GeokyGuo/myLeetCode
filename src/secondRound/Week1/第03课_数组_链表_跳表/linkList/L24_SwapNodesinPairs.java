package secondRound.Week1.第03课_数组_链表_跳表.linkList;

import util.ListNode;

import java.util.HashMap;

public class L24_SwapNodesinPairs {
    public static void main(String[] args) {
        ListNode te = new ListNode(1);
        te.next = new ListNode(2);
        te.next.next = new ListNode(3);
        te.next.next.next = new ListNode(4);
        te.next.next.next.next = new ListNode(5);

        ListNode re = swapPairs5(te);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
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
        ListNode p = swapPairs3(tmp.next);
        head.next = p;
        //将2节点指向1
        tmp.next = head;
        return tmp;
    }

    //复习  交换指针法 ---改造过的  kgroup中的尾，可以不重复获取
    public static ListNode swapPairs5(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode last;
        ListNode temp ;
        while (cur != null ) {
            last = cur.next;
            if(last == null) break;
            temp = last.next;

            pre.next = last;
            last.next = cur;
            cur.next = temp;

            pre = cur;
            cur = cur.next;
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

