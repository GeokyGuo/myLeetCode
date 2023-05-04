package HW牛客.简单;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class test09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        Set<Character> set = new LinkedHashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
        }
        set.forEach(System.out::println);

    }
}


//对插入顺序敏感的 可以使用linked数据结构，  对排序敏感的 可以转list后再排序  todo  忘掉treemap的使用