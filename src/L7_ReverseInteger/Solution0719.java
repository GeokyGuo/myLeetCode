package L7_ReverseInteger;

/*
Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:

        Input: 123
        Output: 321
        Example 2:

        Input: -123
        Output: -321
        Example 3:

        Input: 120
        Output: 21
        Note:
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/


public class Solution0719 {
    public static void main(String[] args) {
        int x = -120;
        int a = reverse(x);
        System.out.println(a);
    }

    public static int reverse(int x) {
        long y = 0;
        long sum = 0;
        while (x != 0) {
            y = x % 10;
            sum = sum * 10 + y;
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) sum;
    }


}
