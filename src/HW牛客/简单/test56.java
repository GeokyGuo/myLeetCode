package HW牛客.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test56 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {

            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    list.add(j);
                }
            }
            int sum = 0;
            for (Integer integer : list) {
                sum += integer;
            }
            if (sum == i) {
                count++;
            }

        }
        System.out.println(count);

    }
}

