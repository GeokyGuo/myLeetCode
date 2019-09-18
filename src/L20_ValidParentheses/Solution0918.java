package L20_ValidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution0918 {
    public static void main(String[] args) {
        String s = "([)]";
        HashMap<Character, Character> map = new HashMap();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();

        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();


        int i = 0;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                i++;
                continue;

            }

            Character a = s.charAt(i);
            Character b = map.get(stack.peek());
            if (b == null) {
                return false;
            }
            if (a == b) {

                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }


        return stack.isEmpty();
    }
}
