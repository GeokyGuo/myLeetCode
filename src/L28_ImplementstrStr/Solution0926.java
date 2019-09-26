package L28_ImplementstrStr;

public class Solution0926 {

    public static void main(String[] args) {
        String haystack = "safaaf";
        String needle = "aaf";
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

    private static int[] getNext(String needle) {
        if (needle.length() == 0) {                 //注意点1
            return null;
        }
        int[] next = new int[needle.length()];

        next[0] = -1;
        int i = 0;
        int j = -1;

        while (i < needle.length() - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
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