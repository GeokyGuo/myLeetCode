package HW牛客.简单;

import java.util.Scanner;

public class test108 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int i1 = in.nextInt();

        int res = 0;
        for (int j = Math.max(i, i1); true; j++) {
            if (j % i == 0 && j % i1 == 0) {
                res = j;
                break;
            }
        }
        System.out.println(res);

    }
}
