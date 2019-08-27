package L83_RemoveDuplicatesfromSortedList;


import util.ListNode;

public class Solution {
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


    //思想  双指针尾插法 构建新的链表，注意尾插法要清空尾巴
    public static ListNode deleteDuplicates(ListNode l) {
        if (l == null) {
            return l;                                                       //没有考虑为空的情况
        }
        ListNode head = new ListNode(-1);
        ListNode last = head;

        last.next = l;
        last = last.next;
        l = l.next;

        while (l != null) {
            if (l.val != last.val) {
                last.next = l;
                last = l;
                l = l.next;
            } else {
                l = l.next;
            }
        }
        last.next = null;                                                   //如果是重排都还好说，但是涉及删除，新的返回链表可能比原来的链表短的情况，
        //用老的节点连上新的节点后，老节点后边是有捎带的一长串的，，因此最后要把last后边的清空
        return head.next;
    }


    //思想是  删除当前节点的模型， 注意清空野指针
    public static ListNode deleteDuplicates1(ListNode l) {
        if (l == null) {
            return l;
        }

        ListNode pre = l;
        ListNode p = l.next;


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
        return l;
    }

    public ListNode deleteDuplicates3(ListNode head) {   //力扣上的方法，，很简洁
        ListNode current = head;
        while (current != null && current.next != null) {            //思想是双指针，但是实际的代码也可以用一个指针去表示
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}