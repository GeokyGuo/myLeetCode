package L66_PlusOne;

import java.util.Arrays;

public class Solution0718 {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        arr = plusOne(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] += 1;
        int c = 0;
        int y = 0;
        int sum = 0;
        while (i > -1) {
            sum = digits[i] + c;
            c = sum / 10;
            y = sum % 10;
            digits[i] = y;
            i--;
        }
        if (c != 0) {
            int[] re = new int[digits.length + 1];
            re[0] = c;
            return re;
        } else {
            return digits;
        }
    }

}
