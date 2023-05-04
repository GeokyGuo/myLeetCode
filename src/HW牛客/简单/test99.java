package HW牛客.简单;

import java.util.Scanner;

public class test99 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        int count = 0;
        for (int j = 0; j <= i; j++) {
            if (isValidZi(j)) {
                count++;
            }
        }
        System.out.println(count);

    }

    static boolean isValidZi(int i) {
        String sq = i * i + "";
        String or = i + "";

        for (int j = or.length() - 1, k = sq.length() - 1; j >= 0; j--, k--) {

            if (or.charAt(j) != sq.charAt(k)) {
                return false;
            }
        }

        return true;
    }

}


//比较两个字符串最后几位的时候  要用双指针！

//api中有 string.endWith 方法 todo