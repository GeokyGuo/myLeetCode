package HW牛客.中等;

import java.util.Scanner;

public class test48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(" ");
        int n = Integer.parseInt(s[0]);
        int firstVal = Integer.parseInt(s[1]);


        Node head = new Node(firstVal);

        for (int i = 2; i < n + 1; i++) {
            int i1 = Integer.parseInt(s[i * 2 - 1]);
            int i2 = Integer.parseInt(s[i * 2 - 2]);
            Node target = findTarget(head, i1);
            Node temp = target.next;
            target.next = new Node(i2);
            target.next.next = temp;
        }

        int last = Integer.parseInt(s[s.length - 1]);
        Node node = deleteTarget(head, last);

        Node print = node.next;
        while (print != null) {
            System.out.print(print.val + " ");
            print = print.next;
        }

    }

    private static Node deleteTarget(Node head, int last) {
        Node newHead = new Node(-1);
        newHead.next = head;

        Node pre = newHead;
        while (head != null) {
            if (head.val == last) {
                pre.next = head.next;
                head.next = null;
                return newHead;
            }
            pre = head;
            head = head.next;

        }

        return newHead;
    }

    static Node findTarget(Node head, int val) {
        Node cur = head;

        while (cur != null) {
            if (cur.val == val) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }
}


class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
