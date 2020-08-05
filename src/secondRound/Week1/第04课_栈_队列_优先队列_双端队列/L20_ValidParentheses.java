package secondRound.Week1.第04课_栈_队列_优先队列_双端队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class L20_ValidParentheses {
    public static void main(String[] args) {

    }

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push('I');

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == stack.peek()) {
                stack.pop();
            } else if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else {
                return false;
            }
        }
        stack.pop();
        return stack.isEmpty();
    }

    //标准，参考
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char alp : s.toCharArray()) {
            if (alp == '(') stack.push(')');
            else if (alp == '[') stack.push(']');
            else if (alp == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != alp) return false;
        }
        return stack.isEmpty();
    }

    //复习
    public boolean isValid3(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == stack.peek()) stack.pop();
            else if (s.charAt(i) == '{') stack.push('}');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '(') stack.push(')');
            else return false;
        }

        return stack.isEmpty();
    }

}
