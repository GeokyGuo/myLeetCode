package firstRound.L28_ImplementstrStr;

public class Solution0719 {

    public static void main(String[] args) {  //考虑 主串或者 模式串为空的情况
        String haystack = "";
        String needle = "aa";
        int re = strStr(haystack, needle);
        System.out.println(re);
    }

    public static int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        if (next == null) {
            return 0;
        }

        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static int[] getNext(String str) {
        if (str.length() == 0) {
            return null;
        }
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