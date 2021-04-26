package secondRound.Week8.第20课_字符串算法;

public class L344_Reverse_String {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length;
        char temp;
        while (i < j) {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
}
