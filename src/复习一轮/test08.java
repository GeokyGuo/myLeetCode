package 复习一轮;

import java.util.*;

public class test08 {
    public static void main(String[] args) {
    }

    //50
    public double myPow(double x, int n) {
        return n > 0 ? myPow1(x, n) : 1 / myPow1(x, -n);
    }

    private double myPow1(double x, int n) {
        if (n == 0) return 1;
        double temp = myPow1(x, n / 2);

        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }

    //17
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {  //todo  处理边界情况

            return res;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        dfsletterCombinations(digits, map, 0, res, "");
        return res;
    }

    private void dfsletterCombinations(String digits, HashMap<Character, String> map, int i, List<String> res, String path) {
        if (path.length() == digits.length()) {
            res.add(path);
            return;
        }

        String s = map.get(digits.charAt(i));
        for (Character character : s.toCharArray()) {
            dfsletterCombinations(digits, map, i + 1, res, path + character);
        }

    }

    //51
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        HashSet<Integer> col = new HashSet<>(), main = new HashSet<>(), sub = new HashSet<>();

        dfssolveNQueens(col, main, sub, n, res, 0, path);
        return res;

    }

    private void dfssolveNQueens(HashSet<Integer> col, HashSet<Integer> main, HashSet<Integer> sub, int n, List<List<String>> res, int row, List<Integer> path) {
        if (row == n) {
            res.add(convert2string(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
                col.add(i);
                main.add(row - i); //todo 主对角线和副对角线的特征要写清楚
                sub.add(row + i);

                path.add(i);
                dfssolveNQueens(col, main, sub, n, res, row + 1, path);
                path.remove(path.size() - 1);

                sub.remove(row + i);
                main.remove(row - i);
                col.remove(i);
            }
        }
    }

    private List<String> convert2string(List<Integer> path) {
        int n = path.size();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            sb.replace(path.get(i), path.get(i) + 1, "Q");
            res.add(sb.toString());
        }
        return res;
    }


}
