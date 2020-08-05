package secondRound.Week1.第03课_数组_链表_跳表.homework;

public class L66_PlusOne {
    public static void main(String[] args) {
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int c = 1;
        int y = 0;
        int sum = 0;

        while (i >= 0) {
            sum = digits[i] + c;
            c = sum / 10;
            y = sum % 10;
            digits[i] = y;
            i--;
        }
        if (c != 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }
        return digits;
    }
}
