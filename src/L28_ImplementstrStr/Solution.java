package L28_ImplementstrStr;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
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
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        } else return -1;
    }

    public static int[] getNext(String str) {
        int len = str.length();
        if (len == 0) return null;

        int[] next = new int[len];
        next[0] = -1;

        int i = 0;
        int j = -1;
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