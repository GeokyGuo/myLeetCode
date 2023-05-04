package HW牛客.简单;

import java.util.Calendar;
import java.util.Scanner;

public class test73 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();


        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, day, 0, 0, 1);// todo 计算时间时 要大于完整的周期，因此加了一秒
        System.out.println(date.getTimeInMillis());

        Calendar date1 = Calendar.getInstance();
        date1.set(year, 0, 1, 0, 0, 0);
        System.out.println(date1.getTimeInMillis());

        long l = date.getTimeInMillis() - date1.getTimeInMillis();
        long l1 = l / (1000 * 3600 * 24);
        System.out.println(l1 + 1);

    }
}


//本题不难但是 是知识的薄弱点，关于日期的设置和计算 todo

//Calendar getInstance初始化  set（年月日时分秒）设置精确时间，月份从0开始算
//Calendar

//2.可以对时间进行加减 add
//Calendar c3 = Calendar.getInstance();
//
//c3.add(Calendar.DATE, 100);

//3.可以判断时间的前后顺序     public boolean after(Object when)   c1.after(c2);
