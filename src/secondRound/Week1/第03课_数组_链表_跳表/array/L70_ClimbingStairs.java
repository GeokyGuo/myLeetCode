package secondRound.Week1.第03课_数组_链表_跳表.array;

public class L70_ClimbingStairs {
    public static void main(String[] args) {

    }

    //动态规划的方法
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 2; i < n; i++) {
            temp[i + 1] = temp[i] + temp[i - 1];
        }
        return temp[n];
    }

    public int climbStairs2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 1, last = 2;
        int re = 0;
        for (int i = 3; i <= n; i++) {
            last = last + pre;
            pre = last - pre;
        }
        return last;
    }

    //复习
    public int climbStairs3(int n) {
        int a = 1;
        int b = 2;
        if (n == 1) {
            return a;
        }

        int i = 2;
        while (i < n) {
            b = a + b;
            a = b - a;
            i++;
        }
        return b;
    }
}
