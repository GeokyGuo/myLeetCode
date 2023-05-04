package HW牛客.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        List<String> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            String next = in.next();
            list.add(next);
        }

        list.sort(String::compareTo);
        list.forEach(System.out::println);

    }
}
