package L14LongestCommonPrefix;

/*Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
        Note:

        All given inputs are in lowercase letters a-z.*/
public class Solution0724 {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "a";
        //  strArr[1] = "";
        //strArr[2] = "";
        String s = longestCommonPrefix1(strArr);
        //String s = longestCommonPrefix(strArr);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int i = 0;
        while (i < strs[0].length()) {
            char ch = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length()) {
                    if (strs[j].charAt(i) != ch) {
                        return strs[0].substring(0, i);
                    }
                } else {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
        return strs[0].substring(0, i);
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
