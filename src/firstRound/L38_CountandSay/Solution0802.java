package firstRound.L38_CountandSay;

import java.util.ArrayList;

public class Solution0802 {
    public static void main(String[] args) {
        int n = 5;
        String re = countAndSay(n);
        System.out.println(re);
    }

    public static String countAndSay(int n) {

        String s = "1";
        int i = 1;
        while (i < n) {
            s = getNext(s);
            i++;
        }

        return s;
    }

    static String getNext(String s) {
        int len = s.length();

        int count = 0;
        char temp = s.charAt(0);
        StringBuffer sb = new StringBuffer();

        int i = 0;
        while (i < len) {
            while (i < len && s.charAt(i) == temp) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(temp);

            if (i == len) {
                break;

            }
            temp = s.charAt(i);
            count = 0;
        }
        return sb.toString();
    }


}

