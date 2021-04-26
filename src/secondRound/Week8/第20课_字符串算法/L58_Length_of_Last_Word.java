package secondRound.Week8.第20课_字符串算法;

public class L58_Length_of_Last_Word {
    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            count++;
        }
        return count;
    }
}
