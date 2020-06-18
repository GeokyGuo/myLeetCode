package firstRound.L9_PalindromeNumber;

/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

        Example 1:

        Input: 121
        Output: true
        Example 2:

        Input: -121
        Output: false
        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
        Example 3:

        Input: 10
        Output: false
        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
        Follow up:

        Coud you solve it without converting the integer to a string?*/


public class Solution0722 {
    public static void main(String[] args) {
        int x = 22022;
        System.out.println(isPalindrome(x));

    }

    public static boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0) {
            return false;
        }
        int y;
        int sum = 0;
        while (x > sum) {
            y = x % 10;
            sum = sum * 10 + y;
            x = x / 10;
        }
 /*       if (sum == x || sum / 10 == x) {
            return true;
        } else {
            return false;
        }*/   //这样写太冗余了，if true return true,
        return sum == x || sum / 10 == x;
    }


}
