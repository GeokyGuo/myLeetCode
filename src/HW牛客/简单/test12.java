package HW牛客.简单;

import java.util.*;

public class test12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        char[] chars = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());

    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();


        ArrayList<Character> chars1 = new ArrayList<>();
        for (char c : s.toCharArray()) {
            chars1.add(c);
        }
        Collections.reverse(chars1);
        chars1.forEach(System.out::print);

    }
}
