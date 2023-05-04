package HW牛客.简单;

import java.util.*;

public class test23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Map<String, Integer> map = new HashMap<>();

        //统计每一个
        for (char item : s.toCharArray()) {
            String c = item + "";
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //得到最小
        Collection<Integer> values = map.values();
        Integer integer = values.stream().min(Comparator.comparingInt(i -> i)).get();


        //遍历删除
//        String temp = s;
//        List<String> list = new ArrayList<>();
//        map.forEach((key, value) -> {
//            if (value.equals(integer)) {
//                String replace = temp.replace(key, "");
//                list.add(replace);
//            }
//        });

        for (String s1 : map.keySet()) {
            if (map.get(s1).equals(integer)) {
                s = s.replace(s1, "");
            }
        }
        System.out.println(s);
    }
}

//lamda表达式中 不能改变外部变量的引用 //todo
//容器的遍历  一种是lamda表达式，  一种是传统方式
