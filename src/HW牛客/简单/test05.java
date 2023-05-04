package HW牛客.简单;

import java.util.Scanner;

public class test05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        String substring = s.substring(2);

        int i = Integer.parseInt(substring, 16);
        System.out.println(i);

    }
}
