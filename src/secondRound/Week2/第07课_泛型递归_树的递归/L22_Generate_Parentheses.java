package secondRound.Week2.第07课_泛型递归_树的递归;

import java.util.ArrayList;
import java.util.List;

public class L22_Generate_Parentheses {
    public static void main(String[] args) {

    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(list, n, 0, 0, "");
        return list;
    }

    void generateParenthesis(List list, int n, int left, int right, String s) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        //两种递归终结的条件都可以
//        if (s.length() == 2 * n) {
//            list.add(s);
//            return;
//        }
        if (left < n) {
            generateParenthesis(list, n, left + 1, right, s + "(");
        }
        if (right < left) {
            generateParenthesis(list, n, left, right + 1, s + ")");
        }
    }
}
