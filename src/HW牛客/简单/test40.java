package HW牛客.简单;

import java.util.Scanner;

public class test40 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        int[] count = new int[4];//英文，空格，数字，其他字符

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) count[0]++;
            else if (Character.isWhitespace(c)) count[1]++;
            else if (Character.isDigit(c)) count[2]++;
            else count[3]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }

    }
}
//todo  API的使用
//Character.isLetter
//Character.isDigit(c))
//Character.isSpaceChar(c))