package L125_ValidPalindrome;

public class Solution0830 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;

        while (l != r) {
            while (l != r && !isSig(s.charAt(l))) {
                l++;
            }

            while (l != r && !isSig(s.charAt(r))) {
                r--;
            }
            char ch1 = conCase(s.charAt(l));
            char ch2 = conCase(s.charAt(r));
            if (ch1 != ch2) {
                return false;
            }

            if (r - l == 1) {
                l++;
            } else if (r != l) {
                l++;
                r--;

            }

        }
        return true;
    }

    static boolean isSig(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }

        return false;
    }

    static char conCase(char ch1) {
        if (ch1 >= 'a' && ch1 <= 'z') {
            return (char) (ch1 + ('A' - 'a'));
        }

        return ch1;
    }
}
