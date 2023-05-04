package HW牛客.简单;

import java.math.BigDecimal;
import java.util.Scanner;

public class test105 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int countN = 0;
        int countP0 = 0;
        int sumP0 = 0;
        while (in.hasNextInt()) {
            int x = in.nextInt();
            //统计负数的个数
            //统计0或者正数的个数，和总和
            if (x < 0) {
                countN++;
            } else {
                countP0++;
                sumP0 += x;
            }
        }

        System.out.println(countN);
        System.out.println(countP0 == 0 ? 0.0 : new BigDecimal(sumP0).divide(new BigDecimal(countP0), 1, BigDecimal.ROUND_HALF_UP).toString());

    }
}


//  /  这个除法符号的含义，  整数除整数 结果必为整数，可以用int 也可以用double接收      浮点数除整数，结果为小数， 用int接收为整数，用小数接收为小数