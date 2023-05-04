package HW牛客.简单;

import java.util.*;

public class test54 {//抄的代码

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            s = s.replace("[", "(");
            s = s.replace("{", "(");
            s = s.replace("]", ")");
            s = s.replace("}", ")");
            int res = solution(s);
            System.out.println(res);
        }
    }

    public static int solution(String s) {
        char ops = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops = c;
                continue;
            }
            int num = 0;
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
            } else if (c == '(') {
                int left = i;
                int right = i + 1;
                int count = 1;
                while (right < s.length() && count > 0) {
                    if (s.charAt(right) == '(') count++;
                    else if (s.charAt(right) == ')') count--;
                    right++;
                }
                i = right - 1;
                num = solution(s.substring(left + 1, right - 1));
            }
            if (ops == '+') stack.push(num);
            else if (ops == '-') stack.push(-num);
            else if (ops == '*') stack.push(stack.pop() * num);
            else if (ops == '/') stack.push(stack.pop() / num);
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}