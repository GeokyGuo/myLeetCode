package HW牛客.简单;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class test34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for (char aChar : chars) {
            System.out.print(aChar);

        }

    }
}

//char 的排序就像int的排序一样，不需要用一个comparetor去排序
