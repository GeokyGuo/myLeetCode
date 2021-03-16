package secondRound.Week2.第08课_分治_回溯;

import java.util.*;

public class L51_N_Queens {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("qwer");
        sb.replace(2, 3, "8");
        System.out.println(sb.toString());

    }

    //三种思路，可以用  hash表来表示状态，可以用used数组表示状态，还可以用位图法 表示状态，N皇后2的 解法用的就是位图法，后边再研究吧


    Set<Integer> col;
    Set<Integer> master;
    Set<Integer> slave;
    int n;
    List<List<String>> reList;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        col = new HashSet<>();
        master = new HashSet<>();
        slave = new HashSet<>();
        reList = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        dfs(stack, 0);

        return reList;
    }

    void dfs(Deque stack, int row) {
        if (stack.size() == n) {
            List<String> re = stack2String(stack);
            reList.add(re);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !master.contains(row -i) && !slave.contains(row + i)) {

                col.add(i);
                master.add(row - i);
                slave.add(row + i);
                stack.add(i);

                dfs(stack, row + 1);

                stack.remove(i);
                slave.remove(row + i);
                master.remove(row - i);
                col.remove(i);
            }
        }
    }

    List<String> stack2String(Deque<Integer> stack) {
        List<String> re = new ArrayList<>();
        StringBuffer sb;
        for (Integer integer : stack) {
            sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            sb.replace(integer, integer + 1, "Q");
            re.add(sb.toString());
        }
        return re;
    }
}
