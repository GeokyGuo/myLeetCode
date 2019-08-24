package L58_LengthofLastWord;

public class Solution0824 {
    public static void main(String[] args) {
        String str = " qwer 13 ";
        int re = lengthOfLastWord(str);
        System.out.println(re);
    }

    public static int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int end = 0;
        int begin = 0;

        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        begin = i;


        return end - begin ;
    }
}
