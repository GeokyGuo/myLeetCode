package HW牛客.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int left = i;
            int right = i + 8;
            if (right <= s.length()) {
                res.add(s.substring(left, right));
            } else {
                String s0 = addzero(s.substring(left, s.length()));
                res.add(s0);
            }
            i = right;
        }
        res.forEach(System.out::println);

    }

    private static String addzero(String str) {
        int length = str.length();
        int sub = 8 - length;
        for (int i = 0; i <sub; i++) {
            str += "0";
        }

        return str;
    }

}
