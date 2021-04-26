package secondRound.Week8.第20课_字符串算法;

public class L14_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        String pre = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j < str.length() && j < pre.length(); j++) {
                if (str.charAt(j) != pre.charAt(j)) {
                    break;
                }
            }
            pre = pre.substring(0, j);
        }
        return pre;
    }
}
