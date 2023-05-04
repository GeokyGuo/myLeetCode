package HW牛客.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test06 {//未ac

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        List<Integer> res = new ArrayList<>();

        for (int j = 2; j <= i; j++) {
            if (i % j == 0) {
                i = i / j;
                res.add(j);
                j = 1;
            }
        }
        res.forEach(e -> System.out.print(e + " "));

    }
}
