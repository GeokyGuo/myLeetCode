package HW牛客.简单;

import java.util.Scanner;

public class test106 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        StringBuffer sb = new StringBuffer(s);
        System.out.println(sb.reverse().toString());
    }
}


//85 也涉及到字符串反转t