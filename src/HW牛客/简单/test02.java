package HW牛客.简单;

import java.util.Scanner;

public class test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = s.toLowerCase();

        String i = in.next();
        String i1 = i.toLowerCase();

        int count = 0;
        for (Character c : s1.toCharArray()) {
            if (c == i1.charAt(0)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
