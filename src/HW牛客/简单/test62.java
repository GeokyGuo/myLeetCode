package HW牛客.简单;

import java.util.Scanner;

public class test62 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int i = in.nextInt();

            String s = Integer.toString(i, 2);
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '1') count++;
            }

            System.out.println(count);
        }

    }
}
