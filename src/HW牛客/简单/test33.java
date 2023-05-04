package HW牛客.简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test33 {//未ac
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        ArrayList<String> res = getStringList(s1, s2);
        res.forEach(System.out::println);
    }

    private static ArrayList<String> getStringList(String s1, String s2) {
        String[] ipTen = s1.split("\\.");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ipTen.length; i++) {
            String s = Integer.toString(Integer.parseInt(ipTen[i]), 2);
            sb.append(s);
        }

        String res1 = Integer.parseInt(sb.toString(), 2) + "";

        String s = Integer.toString(Integer.parseInt(s2, 2));
        int length = s.length();
        String substring4 = s.substring(length - 8, length);
        String substring3 = s.substring(length - 16, length - 8);
        String substring2 = s.substring(length - 24, length - 16);
        String substring1 = s.substring(0, length - 24);

        StringBuffer sb2 = new StringBuffer();
        sb2.append(Integer.parseInt(substring1, 2)).append(".");
        sb2.append(Integer.parseInt(substring2, 2)).append(".");
        sb2.append(Integer.parseInt(substring3, 2)).append(".");
        sb2.append(Integer.parseInt(substring4, 2));

        String res2 = sb2.toString();

        return new ArrayList<>(Arrays.asList(res1, res2));
    }


}
