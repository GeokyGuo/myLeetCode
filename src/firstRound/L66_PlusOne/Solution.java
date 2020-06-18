package firstRound.L66_PlusOne;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {9, 9, 9};
        arr = plusOne(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0) {
                return dealMoreTen(digits, i);
            } else {

                dealMoreTen(digits, i);
            }
        }
        return digits;
    }

    public static int[] dealMoreTen(int[] digits, int i) {
        if (i == 0 && digits[i] > 9) {
            int[] newarr = new int[digits.length + 1];
            newarr[0] = 1;
            newarr[1] = digits[0] - 10;
            for (int j = 1; j < digits.length; j++) {
                newarr[j + 1] = digits[j];
            }
            return newarr;

        } else if (digits[i] > 9) {
            digits[i] -= 10;
            digits[i - 1] += 1;
        }

        return digits;
    }

}
