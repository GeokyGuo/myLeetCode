package HW牛客.简单;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charIsValid(i, s)) continue;
            StringBuffer sb = new StringBuffer();
            while (charIsValid(i, s)) {
                sb.append(s.charAt(i));
                i++;
            }
            list.add(sb.toString());
        }
        Collections.reverse(list);
        list.forEach(e -> System.out.print(e + " "));
    }

    private static boolean charIsValid(int i, String s) {
        if (i >= s.length()) return false;
        char c = s.charAt(i);
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
