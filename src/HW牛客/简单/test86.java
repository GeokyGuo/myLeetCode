package HW牛客.简单;

import java.util.Scanner;

public class test86 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = Integer.toString(n, 2);

        int max = 0;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                last++;
                max = Math.max(last, max);
            } else {
                last = 0;
            }

        }
        System.out.println(max);
        in.close();
    }
}
