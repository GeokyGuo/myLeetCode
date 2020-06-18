package firstRound.L20_ValidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution0828 {
    public static void main(String[] args) {
        String s = "([)]";
        HashMap<Character, Character> map = new HashMap();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                i++;
                continue;
            }
            if (map.get(stack.peek()) == null) {
                return false;
            }
            if (map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }
        return stack.isEmpty();
    }

}
