package secondRound.Week8.第20课_字符串算法;

public class L680_Valid_Palindrome_II {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    boolean isPalindrome(String str, int i, int j){
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            j--;
            i++;
        }
        return true;
    }
}
