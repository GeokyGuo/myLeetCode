package L20_ValidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution0723 {
    public static void main(String[] args) {
        String s = "()00()";
        HashMap<Character, Character> map = new HashMap();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');


        int i = 0;
        Stack<Character> stack = new Stack();
        while (i < s.length()) {

            char ch = s.charAt(i);
            if (stack.empty()) {
                stack.push(ch);
                i++;
                continue;
            }

            Character a = map.get(ch);
            Character b = stack.peek();
            if (a != b) {
                stack.push(ch);
            } else {
                stack.pop();
            }
            i++;
        }
        return stack.empty();
    }
}


/** 1.char是类似于int的数据类型，不能直接判断char是否等于null，char也可以自动拆装箱，所以装箱以后再判断是否为null
 * 2.return的地方，本身就是boolean，不用if后再return
 * 3.栈空时继续比较 可能发生空指针
 *
 *
 *
 *
 * **/
