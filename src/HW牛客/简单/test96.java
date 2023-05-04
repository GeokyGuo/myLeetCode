package HW牛客.简单;

import java.util.Scanner;

public class test96 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append("*");
                int last = findLastDigtal(str, i);
                int j = i;
                while (j < last) sb.append(str.charAt(j++));
                sb.append("*");
                i = last - 1;
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }

    private static int findLastDigtal(String str, int i) {
        int j = i + 1;
        while (j < str.length() && Character.isDigit(str.charAt(j))) {
            j++;
        }
        return j;
    }

    //下边的方法更合理
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append("*");
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append("*");
                i--;
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());

    }

}


//if条件 发现了开端， while同一个条件 去循环