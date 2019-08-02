package L38_CountandSay;


public class Solution0718 {
    public static void main(String[] args) {
        int n = 7;
        String re = countAndSay(n);
        System.out.println(re);
    }

    public static String countAndSay(int n) {

        String s = "1";
        for (int i = 1; i < n; i++) {
            s = getNextNum(s);

        }
        return s;
    }

    private static String getNextNum(String s) {

        int i = 0;
        char temp = s.charAt(0);
        int count = 0;

        StringBuffer sb = new StringBuffer();

        /**这一段是统计有几个几的核心代码，双while 加 if 模板，记住*/
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == temp) {  //必须是i<len  在前，==在后，不然会出现空指针
                count++;
                i++;
            }
            sb.append(count);
            sb.append(temp);
            if (i < s.length()) {
                count = 0;
                temp = s.charAt(i);
            }
            /**这一段是统计有几个几的核心代码，双while 加 if 模板，记住*/
        }

        return sb.toString();
    }


}

