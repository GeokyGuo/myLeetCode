package HW牛客;

import java.util.Scanner;

public class 输入输出练习 {
    public static void main(String[] args) {
//        test4(args);
//        test7(args);

        String a = "1234";
        String substring = a.substring(1, 1);
        System.out.println(substring);
    }

    public static void test1(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);

        }
    }


    public static void test2(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public static void test3(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }

    public static void test4(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean b = in.hasNextInt();
        while (b) {
            int n = in.nextInt();
            if (n == 0) break;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += in.nextInt();
            }
            System.out.println(sum);

        }
    }

    //    https://blankspace.blog.csdn.net/article/details/102529833?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-102529833-blog-78162518.235%5Ev32%5Epc_relevant_default_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-102529833-blog-78162518.235%5Ev32%5Epc_relevant_default_base3&utm_relevant_index=2
//    https://developer.aliyun.com/ask/74287?spm=a2c6h.13159736  while 怎么结束
//    https://ost.51cto.com/posts/2600     分成几个类型
//    https://cloud.tencent.com/developer/article/2100706  调用两遍nextLine
//    https://www.cnblogs.com/jane0118/p/12917255.html  最好搭配使用
    public static void test5(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
//        while (scan.hasNext()) {
        System.out.println(scan.nextInt());

        System.out.println(count++);

//        }
        System.out.println("====");

    }

    public static void test6(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());

            System.out.println(count++);

        }
        System.out.println("====");

    }

    public static void test7(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;
        while (scan.hasNext()) {
            System.out.println("next:" + scan.nextInt());


            String s = scan.nextLine();
            System.out.println("nextLine:" + s);
//
//            String s1 = scan.nextLine();
//            System.out.println("nextLine1:" + s1);


            System.out.println("count:" + count++);

        }
        System.out.println("====");

    }


}


//笔记
//hasnext 是一类阻塞函数，hasnextint结束的条件是 ctrl+d 或 输入非int
//in.next in.nextInt 也是阻塞函数
//1.第一类是 nextInt 指定类型
//2.第二类是字符串类  nextLine()  next()
//使用完nextXXX 需要使用nextLine时，需要在nextXXX后紧接一个nextLine消除换行符后，再真正调用nextLine
//println 要区分是否换行
