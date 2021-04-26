package secondRound.Week8.第20课_字符串算法;

public class L917_Reverse_Only_Letters {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            while (i < j && !((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z'))) i++;
            while (i < j && !((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z'))) j--;
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(arr);

    }
}
