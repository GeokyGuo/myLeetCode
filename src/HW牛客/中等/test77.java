package HW牛客.中等;

import java.util.*;

public class test77 {

    static Deque<Integer> stack = new ArrayDeque<>();
    static List<String> res = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] order = new int[n];
        for (int j = 0; j < n; j++) {
            order[j] = in.nextInt();
        }

        getOutStackList(order, 0, "");
        res.sort(Comparator.naturalOrder());
        res.forEach(e ->
        {
            char[] chars = e.toCharArray();
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("");
        });
    }

    private static void getOutStackList(int[] order, int index, String s) {
        if (s.length() == order.length) {
            res.add(s);
            return;
        }

        if (index < order.length) {
            stack.push(order[index]);
            getOutStackList(order, index + 1, s);
            stack.pop();//恢复现场
        }

        if (stack.size() != 0) {
            Integer pop = stack.pop();
            getOutStackList(order, index, s + pop);
            stack.push(pop);//恢复现场
        }
    }
}


//todo  这个回溯的过程可以再体会一下