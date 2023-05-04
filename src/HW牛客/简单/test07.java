package HW牛客.简单;

import java.math.BigDecimal;
import java.util.Scanner;

public class test07 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigDecimal a = in.nextBigDecimal();
        BigDecimal bigDecimal = a.setScale(0, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.intValue());
    }
}
