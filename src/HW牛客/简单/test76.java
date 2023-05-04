package HW牛客.简单;

import java.util.Scanner;

public class test76 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int mul = n * n * n;

        int avg = mul / n;


        int start = 0;
        if (n % 2 == 0) {
            start = (int) (avg - 2 * (n / 2 - 0.5));
        } else {
            start = avg - 2 * (n / 2);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(start);
            sb.append("+");
            start += 2;
        }
        System.out.println(sb.substring(0, sb.length()-1));

    }
}
