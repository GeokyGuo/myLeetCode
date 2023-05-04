package HW牛客.简单;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        int length = getLastWordLength(s);
        System.out.println(length);
    }

    private static int getLastWordLength(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

}
