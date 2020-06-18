package firstRound.L14LongestCommonPrefix;


public class Solution0923 {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "flower";
        strArr[1] = "flow";
        strArr[2] = "flight";
        //String s = longestCommonPrefix1(strArr);
        String s = longestCommonPrefix(strArr);
        System.out.println(s);
    }


    public static String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String pre = strs[0];


        int i = 1;

        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.length() == 0) {
                    return "";
                }
            }
            i++;
        }

        return pre;
    }


}
