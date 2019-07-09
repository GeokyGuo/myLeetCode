package L58_LengthofLastWord;

public class Solution {
    public static void main(String[] args) {
        String str = " qwer 1 ";
        int re = lengthOfLastWord(str);
        System.out.println(re);
    }

    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;
        int end = 0;
        int begin = 0;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        begin = i;
        return end - begin;
    }
}
