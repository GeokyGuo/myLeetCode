package HW牛客.简单;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (in.hasNextInt()) {
            int i = in.nextInt();
            if (i == 0) break;
            list.add(getResult(i));
        }
        list.forEach(System.out::println);
    }

    private static Integer getResult(int i) {

        if (i == 2) return 1;

        int sum = 0;
        int chu = 0;
        int yu = 0;
        do {
            chu = i / 3;
            yu = i % 3;
            sum = sum + chu;

            i = chu + yu;
            if (i == 2) {
                return sum + 1;
            }
        } while (chu != 0);


        return sum;
    }
}


//换汽水的本质 （自己的两个空瓶  正好可以换到 一个汽水）