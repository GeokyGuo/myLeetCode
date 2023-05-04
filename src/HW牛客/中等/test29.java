package HW牛客.中等;

import java.util.Scanner;

public class test29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for (char c : str1.toCharArray()) {
            sb1.append(encrytChar(c));
        }

        for (char c : str2.toCharArray()) {
            sb2.append(decrytChar(c));
        }
        System.out.println(sb1);
        System.out.println(sb2);
    }

    private static char decrytChar(char c) {
        if (Character.isLetter(c)) {
            if (Character.isUpperCase(c)) {
                char c1 = Character.toLowerCase(c);
                int i = (c1 - 'a' + 25) % 26;
                return (char) (i + 'a');
            } else {
                char c1 = Character.toUpperCase(c);
                int i = (c1 - 'A' + 25) % 26;
                return (char) (i + 'A');
            }
        } else {
            return (char) ((c - '0' + 9) % 10 + '0');
        }
    }

    private static char encrytChar(char c) {
        if (Character.isLetter(c)) {
            if (Character.isUpperCase(c)) {
                char c1 = Character.toLowerCase(c);
                int i = (c1 - 'a' + 1) % 26;
                return (char) (i + 'a');
            } else {
                char c1 = Character.toUpperCase(c);
                int i = (c1 - 'A' + 1) % 26;
                return (char) (i + 'A');
            }
        } else {
            return (char) ((c - '0' + 1) % 10 + '0');
        }
    }
}


