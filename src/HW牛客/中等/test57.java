package HW牛客.中等;

import java.math.BigDecimal;
import java.util.Scanner;

public class test57 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String s1 = in.nextLine();
        BigDecimal b1 = new BigDecimal(s);
        BigDecimal b2 = new BigDecimal(s1);
        System.out.println(b1.add(b2));

    }

}
