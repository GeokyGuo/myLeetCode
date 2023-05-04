package HW牛客.简单;

import java.util.Scanner;

public class test85 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length(); j > i; j--) {
                String temp = str.substring(i, j);
                if (isValidHui(temp)) {
                    length = Math.max(length, temp.length());
                }

            }
        }
        System.out.println(length);

    }

    private static boolean isValidHui(String temp) {
        if (temp.equals(new StringBuffer(temp).reverse().toString())) {
            return true;
        }
        return false;
    }
}


//普通数组反转  要转成list，使用Collections反转  todo
//字符数组反转  可以用 stringBuffer  106也是字符串反转