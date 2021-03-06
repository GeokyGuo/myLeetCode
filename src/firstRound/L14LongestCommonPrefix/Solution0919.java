package firstRound.L14LongestCommonPrefix;

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
public class Solution0919 {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "c";
        strArr[1] = "acc";
        strArr[2] = "ca";
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


