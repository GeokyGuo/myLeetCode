package L125_ValidPalindrome;

public class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !isAOrNumber(s.charAt(i))) {
                i++;
            }
            while (i < j && !isAOrNumber(s.charAt(j))) {
                j--;
            }
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (ch1 != ch2) {
                return false;
            }
            i++;
            j--;

        }

        return true;
    }

    static boolean isAOrNumber(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}
