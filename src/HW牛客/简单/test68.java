package HW牛客.简单;

import java.util.*;
import java.util.stream.Collectors;

public class test68 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int method = in.nextInt();
        in.nextLine();//容易忽略的点 todo
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            list.add(s);
        }
        order(method, list);
        list.forEach(System.out::println);
        in.close();

    }

    private static List<String> order(int method, ArrayList<String> list) {

        //逆序
        Comparator<String> comparator0 = (l1, l2) -> {
            String[] s1 = l1.split(" ");
            String[] s2 = l2.split(" ");

            return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
        };

        //正序
        Comparator<String> comparator1 = (l1, l2) -> {
            String[] s1 = l1.split(" ");
            String[] s2 = l2.split(" ");
            return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
        };

        list.sort(method == 0 ? comparator0 : comparator1);
        return list;
    }


}
