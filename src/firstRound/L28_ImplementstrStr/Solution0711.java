package firstRound.L28_ImplementstrStr;

public class Solution0711 {

    public static void main(String[] args) {
        String haystack = "ssaa";
        String needle = "aa";
        int re = strStr(haystack, needle);
        System.out.println(re);
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        while (i < haystack.length() && j < needle.length()) {     //kmp的模板用while写
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {                                     //加减法的 模型：1+3   标号为1的位置，（除开1）后边再延展长度为三的序列，则总序列的最后一个数的下标就是1+3
                                                                                        // 5-3  标号为5的位置， （除开5）前边延展长度为三的序列，则 向前延展最远的位置的数下标为 5-3
            return i - j;
        }

        return -1;
    }

    public static int[] getNext(String str) {
        int i = 0;
        int j = -1;
        int[] next = new int[str.length()];
        next[0] = -1;
        while (i < str.length() - 1) {
            if (j == -1 || str.charAt(i) == str.charAt(j)) {
                i++;
                j++;
                next[i] = j;

            } else {
                j = next[j];
            }
        }

        return next;
    }

}