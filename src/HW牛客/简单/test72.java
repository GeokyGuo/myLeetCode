package HW牛客.简单;

import java.util.Scanner;

public class test72 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();

        for (int x = 0; x < 100; x++) {
            double y = (200 - 14 * x) / 8.0;
            if (Math.round(y) == y && y >= 0) {
                int z = 100 - x - (int) y;
                System.out.println(x + " " + (int) y + " " + z);
            }
        }

    }
}


//判断一个数  是否为整数 有两种方式 todo
//Math.round(y) == y,   y%1==0
