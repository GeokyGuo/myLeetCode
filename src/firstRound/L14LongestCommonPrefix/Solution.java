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
public class Solution {

    public static void main(String[] args) {
        String[] strArr = new String[3];
        strArr[0] = "flower";
        strArr[1] = "flow";
        strArr[2] = "clight";
        //String s = longestCommonPrefix1(strArr);
        String s = longestCommonPrefix2(strArr);
        System.out.println(s);
    }

    //水平法
    public static String longestCommonPrefix1(String[] strs) {


        return null;
    }

    //垂直法
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int j = 0; j < strs[0].length(); j++) {
            char ch = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() == j || ch != strs[i].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

            /*1. strs数组长度为0 忘了考虑，根本不会有strs[0]
            2.str数组长度为1 ， 不会有第二个for循环， 总的retuen没有考虑
            3.substring 前闭后开， 若为 0 0  则想当于反会""*/
}
