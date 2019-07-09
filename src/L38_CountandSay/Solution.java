package L38_CountandSay;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        String re = countAndSay1(n);
        System.out.println(re);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = "11";
        int count = 1;
        ArrayList arrcount = new ArrayList();
        ArrayList arrval = new ArrayList();
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < temp.length() - 1; j++) {
                char chtemp = temp.charAt(j);
                char ch = temp.charAt(j + 1);
                if (chtemp == ch) {
                    count++;
                } else {
                    arrcount.add(count);
                    arrval.add(chtemp);
                    count = 1;
                }
            }
            temp = "";
            for (int k = 0; k < arrcount.size(); k++) {
                temp = temp + (String) arrcount.get(k) + (String) arrval.get(k);
            }
        }


        return temp;
    }

    public static String countAndSay1(int n) {


        String str = "1";
        for (int i = 1; i < n; i++) {
            str = getNext(str);
        }
        return str;
    }

    public static String getNext(String str) {
        StringBuffer re = new StringBuffer();
        int count = 0;
        char temp = str.charAt(0);

        int len = str.length();
        int i = 0;
        while (i < len) {
            if (str.charAt(i) == temp) {
                count++;
                i++;
            } else {
                re.append(count);
                re.append(temp);
                temp = str.charAt(i);
                count = 0;
            }
        }
        re.append(count);
        re.append(temp);

        return re.toString();
    }

    public static String getNext1(String str) {
        StringBuffer re = new StringBuffer();
        int count = 0;
        char temp = str.charAt(0);

        int len = str.length();
        int i = 0;
        while (i < len) {
            while (i < len  && str.charAt(i) == temp) {
                count++;
                i++;
            }
            re.append(count);
            re.append(temp);
            temp = str.charAt(i);
            count = 0;
        }
        re.append(count);
        re.append(temp);

        return re.toString();
    }
}

