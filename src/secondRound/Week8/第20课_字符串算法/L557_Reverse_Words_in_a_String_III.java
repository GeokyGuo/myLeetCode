package secondRound.Week8.第20课_字符串算法;

public class L557_Reverse_Words_in_a_String_III {
    public static void main(String[] args) {
        String test = "Let's take LeetCode contest";
        String s = reverseWords(test);
        System.out.println(s);
    }

    public static String reverseWords(String s) {
        s = s.trim();
        char[] arr = s.toCharArray();

        int i = 0;
        int start = 0;
        int end = 0;
        while (i < arr.length) {
            while (i < arr.length && arr[i] != ' ') i++;

            end = i - 1;
            while (start < end) {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            while (i < arr.length && arr[i] == ' ') i++;
            start = i;
        }
        return String.valueOf(arr);
    }
}
