package HW牛客.简单;

import java.util.*;

public class test08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        in.nextLine();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int j = 0; j < i; j++) {
            String s = in.nextLine();
            String[] s1 = s.split(" ");
            if (map.containsKey(s1[0])) {
                Integer sum = map.get(s1[0]) + Integer.parseInt(s1[1]);
                map.put(s1[0], sum);
            } else {
                map.put(s1[0], Integer.parseInt(s1[1]));
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        entries.stream().sorted(Comparator.comparingInt(e -> Integer.parseInt(e.getKey()))).forEach(e -> {
            System.out.print(e.getKey() + " ");
            System.out.println(e.getValue());
        });

    }
}

//string 排序和 int排序还是有区别的    //todo
//字符串排序中 10 会排在 2  前边