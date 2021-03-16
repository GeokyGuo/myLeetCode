package secondRound.Week1.第03课_数组_链表_跳表.linkList;
import util.ListNode;

public class L25_test {
    public static void main(String[] args) {
        ListNode te = new ListNode(1);
        te.next = new ListNode(2);
        te.next.next = new ListNode(3);
        te.next.next.next = new ListNode(4);
        te.next.next.next.next = new ListNode(5);

        ListNode re = reverseKGroup(te, 3);
        while (re != null) {
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();

        ListNode pre = newHead;
        ListNode cur = head;

        ListNode temp;
        ListNode last = getLast(cur, k);
        if(last == null){
            return head;
        }

        while(cur != null){
            last = getLast(cur, k);
            if(last == null){
                break;
            }
            temp = last.next;
            reveseCur(cur, last);
            pre.next = last;
            cur.next = temp;

            pre = cur;
            cur = temp;


        }

        return newHead.next;

    }

    static ListNode getLast(ListNode cur, int k){
        if(cur == null){
            return null;
        }

        while(k > 1){
            cur = cur.next;
            if(cur == null){
                return null;
            }
            k--;
        }
        return cur;
    }

    static void reveseCur(ListNode head, ListNode last){
        ListNode comp = last.next;
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while(cur != null){
            temp = cur.next;

            cur.next = pre;

            pre = cur;
            cur = temp;
            if(cur == comp){
                break;
            }
        }

    }
}
