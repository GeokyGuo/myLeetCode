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
public class Solution0730 {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "flower";
        strArr[1] = "flow";
        strArr[2] = "fight";
        //String s = longestCommonPrefix1(strArr);
        String s = longestCommonPrefix2(strArr);
        System.out.println(s);
    }

    //水平法
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                if (pre.length() == 0) {
                    return "";
                }
            }
        }
        return pre;
    }

}
