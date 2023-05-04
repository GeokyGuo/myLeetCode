package HW牛客.简单;

import java.util.Scanner;

public class test51 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        Node head = new Node(-1);
        Node cur = head;
        while (in.hasNext()) {
            int i = in.nextInt();
            for (int j = 0; j < i; j++) {
                int i1 = in.nextInt();
                cur.next = new Node(i1);
                cur = cur.next;
            }
            int k = in.nextInt();

            Node newCur = head.next;
            int length = 0;
            while (newCur != null) {
                length++;
                newCur = newCur.next;
            }

            newCur = head.next;
            int count1 = 0;   //目标  length-k
            while (count1 < length - k) {
                newCur = newCur.next;
                count1++;
            }

            System.out.println(newCur.val);
        }
    }


    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
