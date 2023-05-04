package HW牛客.简单;

import java.util.Scanner;

public class test100 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int item = 2;
        int sum = 2;
        for (int i = 1; i < n; i++) {
            item += 3;
            sum += item;
        }

        System.out.println(sum);

    }
}
