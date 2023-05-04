package HW牛客.简单;

import java.math.BigDecimal;
import java.util.Scanner;

public class test97 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int[] nums = new int[i];
        for (int j = 0; j < i; j++) {
            nums[j] = in.nextInt();
        }

        int countN = 0;
        int countP = 0;
        int sumP = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < 0) {
                countN++;
            }

            if (nums[j] > 0) {
                countP++;
                sumP += nums[j];
            }

        }

        //BigDecimal.ZERO.setScale(1) todo 要保留一位小数
        BigDecimal divide = countP == 0 ? BigDecimal.ZERO.setScale(1) : new BigDecimal(sumP).divide(new BigDecimal(countP), 1, BigDecimal.ROUND_HALF_UP);
        System.out.println(countN + " " + divide.toString());
    }
}
