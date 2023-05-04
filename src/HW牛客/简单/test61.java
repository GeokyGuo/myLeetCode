package HW牛客.简单;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test61 {//未ac
    static Set<String> res = new HashSet<>();

    //    public static void main(String[] args) {
//        int[] ints = {12, 12, 34, 6};
//
//        int[] clone = Arrays.copyOfRange(ints, 0, ints.length);
//        System.out.println(Arrays.toString(clone));
//
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        dfssolve(m, n, new int[n]);
        System.out.println(res.size());

    }

    static void dfssolve(int count, int n, int[] path) {
        if (count == 0) {
            int[] clone = Arrays.copyOfRange(path, 0, path.length);
            Arrays.sort(clone);

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) {
                sb.append(clone[i]);
            }
            res.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {

            path[i]++;


            dfssolve(count - 1, n, path);


            path[i]--;
        }
    }
}

//数组的复制 和字符串的裁剪  都是 前闭后开的区间
