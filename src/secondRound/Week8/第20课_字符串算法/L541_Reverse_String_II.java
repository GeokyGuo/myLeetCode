package secondRound.Week8.第20课_字符串算法;

public class L541_Reverse_String_II {
    public static void main(String[] args) {

        String test = "s";
        int k = 2;
        String s = reverseStr(test, k);
        System.out.println(s);

    }

    public static String reverseStr(String s, int k) {
        int i = 0;
        int j = k - 1;
        char[] charArray = s.toCharArray();
        while (i < s.length() && j < s.length()) {
            int start = i;
            int end = j;
            while (start < end) {
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
            i = i + 2 * k;
            j = j + 2 * k;
        }
        j = charArray.length - 1;
        while (i < j && i < charArray.length) {
            while (i < j) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(charArray);
    }


    //    参考别人的代码
    //每次要反转的起点是 0 2k 4k 6k
    public String reverseStr1(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

}
