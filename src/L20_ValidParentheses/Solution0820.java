package L20_ValidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution0820 {
    public static void main(String[] args) {
        String s = "(())";
        HashMap<Character, Character> map = new HashMap();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
//        if (s.length() == 0) {
//
//            return true;
//        }
        HashMap<Character, Character> map = new HashMap();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            char si = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(si);
                i++;
                continue;
            }

/**
 * -----------------------------------------------------------------
 *
 * */
//            Character stacktop = stack.peek();
//            Character mapv = map.get(si);
//            if (stacktop.equals(mapv)) {
//                stack.pop();
//            } else {
//                stack.push(si);
//            }
/**
 * -----------------------------------------------------------------
 *
 * */
            if (map.get(si) == null) {
                stack.push(si);
                i++;
                continue;

            }
            char a = map.get(si);
            char top = stack.peek();
            if (a == top) {
                stack.pop();
            } else {
                stack.push(si);
            }
/**
 * -----------------------------------------------------------------
 *
 * */
            i++;
        }


        return stack.isEmpty();
    }

}
