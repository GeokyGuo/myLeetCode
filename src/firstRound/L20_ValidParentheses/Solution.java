package firstRound.L20_ValidParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s = "([)]";
        HashMap<Character, Character> map = new HashMap();
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        ArrayList<Character> arr = new ArrayList<>();
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (arr.size() == 0) {
                arr.add(ch);
                index++;

            } else {
                char chpre = arr.get(index);
                if (map.get(chpre) == null) {
                    return false;
                }

                if (ch == map.get(chpre)) {
                    arr.remove(index);
                    index--;
                } else {
                    arr.add(ch);
                    index++;
                }

            }


        }
        if (arr.size() == 0) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean isValid2(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.empty()) {
                stack.push(ch);

            } else {
                char chpre = stack.peek();
                if (map.get(chpre) == null) {
                    return false;
                }

                if (ch == map.get(chpre)) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }

            }


        }
        return stack.empty();

    }
}
