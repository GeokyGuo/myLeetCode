package L38_CountandSay;

import java.util.ArrayList;

public class Solution0919 {
    public static void main(String[] args) {
        int n = 6;
        String re = countAndSay(n);
        System.out.println(re);
    }

    public static String countAndSay(int n) {
        String s = "1";

        int i = 2;
        while (i <= n) {
            s = getNext(s);
            i++;
        }
        return s;
    }

    static String getNext(String s) {

        StringBuffer sb = new StringBuffer();
        int count = 0;

        int i = 0;
        while (i < s.length()) {

            char temp = s.charAt(i);
            while (i < s.length() && s.charAt(i) == temp) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(temp);
            count = 0;
        }

        return sb.toString();
    }


}

