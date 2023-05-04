package HW牛客.简单;

import java.util.Scanner;

public class test15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int next = in.nextInt();
        String s = Integer.toString(next, 2);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '1'){
                count++;
            }
        }
        System.out.println(count);

    }
}
