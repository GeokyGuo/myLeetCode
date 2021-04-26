package secondRound.Week8.第20课_字符串算法;

public class L151_Reverse_Words_in_a_String {
    //多联系一下，虽然不难，但是一时还不能立马写出来
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = s.length() - 1;
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
