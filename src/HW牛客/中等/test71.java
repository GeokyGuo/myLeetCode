package HW牛客.中等;

import java.util.Scanner;

public class test71 {//抄的，未ac

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s1 = in.nextLine();
            String s2 = in.nextLine();
            System.out.println(helper(s1, s2, 0, 0));
        }
    }

    private static boolean helper(String s1, String s2, int p1, int p2) {
        //base case
        if (p1 == s1.length() && p2 == s2.length()) {
            return true;
        } else if (p1 == s1.length() || p2 == s2.length()) {
            return false;
        }
        //遇到'*'两种情况，要不就各跳过一个比较后面，要不就s2继续往后跳先不比较
        if (s1.charAt(p1) == '*') {
            return helper(s1, s2, p1, p2 + 1) || helper(s1, s2, p1 + 1, p2 + 1) || helper(s1, s2, p1 + 1, p2);
            //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
        } else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)) {
            return helper(s1, s2, p1 + 1, p2 + 1);
        } else {
            return false;
        }
    }
}

//todo 这个递归的思路可以再背诵一下