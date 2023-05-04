package HW牛客.简单;

import java.util.HashMap;
import java.util.Scanner;

public class test10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();

        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map.size());

    }
}
