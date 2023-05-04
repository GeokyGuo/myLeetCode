package HW牛客.中等;

import java.util.Scanner;

public class test38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();

        double temp = x;
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            if (i <= 3) {
                sum += temp;
            }
            temp = temp / 2.0;

        }

        System.out.println(sum);
        System.out.println(temp);

    }
}
