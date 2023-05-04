package HW牛客.中等;

import java.util.Scanner;

public class test20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();

            //长度校验
            if (str.length() <= 8) {
                System.out.println("NG");
                continue;
            }

            //大写字母，小写字母，数字，其他 校验
            int a = 0, b = 0, c = 0, d = 0;
            for (int i = 0; i < str.length(); i++) {
                char c1 = str.charAt(i);
                if (Character.isLowerCase(c1)) a = 1;
                else if (Character.isUpperCase(c1)) b = 1;
                else if (Character.isDigit(c1)) c = 1;
                else d = 1;
            }

            if (a + b + c + d < 3) {
                System.out.println("NG");
                continue;
            }

            //字符串重复校验
            boolean bo = false;
            for (int i = 3; i < str.length(); i++) {
                if (str.substring(i).contains(str.substring(i - 3, i))) {
                    bo = true;
                    break;
                }
            }
            if (bo) {
                System.out.println("NG");
            } else {
                System.out.println("OK");
            }
        }


    }
}


//todo 大于2的 重复子字符串的校验逻辑  str.substring(i).contains(str.substring(i - 3, i)