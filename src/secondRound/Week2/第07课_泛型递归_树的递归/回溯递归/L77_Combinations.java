package secondRound.Week2.第07课_泛型递归_树的递归.回溯递归;

import java.util.*;

public class L77_Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List list = combine(n, k);
        System.out.println(list.toString());

    }

    static List<List<Integer>> list = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {

        builder(k, n, 1, new ArrayList<Integer>());
        return list;
    }

    static void builder(int k, int n, int start, List<Integer> temp) {

        if (temp.size() == k) {
//            list.add(new ArrayList<>(temp));
            list.add(temp);
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            builder(k, n, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
