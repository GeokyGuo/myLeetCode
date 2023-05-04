package HW牛客.简单;

import java.util.Scanner;

public class test84 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        System.out.println(count);

    }
}
