package HW牛客.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class test11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        Deque<Character> stack = new ArrayDeque<>();
        String str = i + "";
        for (int s = 0; s < str.length(); s++) {
            char c = str.charAt(s);
            stack.push(c);
        }

        while (stack.size() != 0) {
            System.out.print(stack.pop());
        }
    }
}
