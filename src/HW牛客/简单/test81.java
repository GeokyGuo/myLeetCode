package HW牛客.简单;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test81 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();


        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            set.add(s2.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            if (!set.contains(s1.charAt(i))) {
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);

    }
}
