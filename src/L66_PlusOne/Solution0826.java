package L66_PlusOne;

import java.util.Arrays;

public class Solution0826 {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        arr = plusOne(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] plusOne(int[] digits) {
        int c = 1;

        int y = 0;


        int i = digits.length - 1;
        while (i >= 0) {
            y = (digits[i] + c) % 10;
            c = (digits[i] + c) / 10;
            digits[i] = y;
            i--;
        }
        if (c == 1) {
            int[] re = new int[digits.length + 1];
            re[0] = 1;
            return re;
        } else {
            return digits;
        }
    }

}
