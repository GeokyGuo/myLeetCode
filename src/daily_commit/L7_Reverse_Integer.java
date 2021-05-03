package daily_commit;

public class L7_Reverse_Integer {
    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE && pop > 7) return 0;
            if (ans < Integer.MIN_VALUE / 10 || ans == Integer.MIN_VALUE && pop < -8) return 0;

            ans = ans * 10 + pop;
        }
        return ans;
    }
}
