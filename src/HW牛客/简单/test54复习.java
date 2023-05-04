package HW牛客.简单;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class test54复习 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String replace = s.replace("{", "(")
                .replace("}", ")")
                .replace("[", "(")
                .replace("]", ")");

        Long res = solve(replace);
        System.out.println(res);
    }

    private static Long solve(String s) {
        char ops = '+';
        Deque<Long> stack = new ArrayDeque<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;

            //操作
            if (isOpsChar(chars[i])) {
                ops = chars[i];
                continue;
            }

            long num = 0;//下边两个分支的结果都是数字
            if (isDigtal(chars[i])) {//数字
                //拿到数字部分
                StringBuffer sb = new StringBuffer();
                while (i < chars.length && isDigtal(chars[i])) {
                    sb.append(chars[i]);
                    i++;
                }
                num = Long.parseLong(sb.toString());

            } else if (chars[i] == '(') {//括号
                i += 1;
                int left = i;

                int count = 1;
                while (i < chars.length && count > 0) {
                    if (chars[i] == ')') {
                        count--;
                    } else if (chars[i] == '(') {
                        count++;
                    }
                    i++;
                }
                int right = i - 1;
                num = solve(s.substring(left, right));
            }
            i--;

            if (ops == '+') stack.push(num);
            if (ops == '-') stack.push(-num);
            if (ops == '*') stack.push(stack.pop() * num);
            if (ops == '/') stack.push(stack.pop() / num);
        }

        Long res = 0L;
        while (stack.size() != 0) {
            res += stack.pop();
        }

        return res;
    }

    static boolean isOpsChar(Character character) {
        if (character == '+' || character == '-' || character == '*' || character == '/') return true;
        return false;
    }

    static boolean isDigtal(Character character) {
        Integer sub = character - '0';
        if (sub >= 0 && sub <= 9) {
            return true;
        }
        return false;
    }
}


//i--; 注意下标要--

//-num

//核心就是  操作（加减乘除） 操作数（数字或递归解析的数字）
