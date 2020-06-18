package firstRound.L38_CountandSay;

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

/*    作者：powcai
    链接：https://leetcode-cn.com/problems/two-sum/solution/zhi-jie-tui-mo-ni-guo-cheng-by-powcai/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    private String next_time(String res) {
        int i = 0;
        int n = res.length();
        String ans = "";
        while (i < n) {
            int count = 1;
            while ((i < n - 1) && (res.charAt(i) == res.charAt(i + 1))) {
                i++;
                count++;
            }
            ans += (count + "" + res.charAt(i));
            i++;

        }
        return ans;
    }


}

