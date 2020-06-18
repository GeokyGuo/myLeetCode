package firstRound.L58_LengthofLastWord;

public class Solution0718 {
    public static void main(String[] args) {
        String str = " qwer 1 ";
        int re = lengthOfLastWord(str);
        System.out.println(re);
    }

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        while (i > -1 && s.charAt(i) == ' ') {
            i--;
        }
        int end = i;
        while (i > -1 && s.charAt(i) != ' ') {
            i--;
        }
        int begin = i;
        return end - begin;
    }
}
