package firstRound.L42_TrappingRainWater;

import java.util.Arrays;

public class Solution0830 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int re = trap(height);
        System.out.println(re);
    }

    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int d[] = new int[height.length];
        int y[] = new int[height.length];

        d[0] = height[0];
        int i = 1;
        while (i < height.length) {
            if (height[i] > d[i - 1]) {
                d[i] = height[i];
            } else {
                d[i] = d[i - 1];
            }
            i++;
        }

        y[y.length - 1] = height[height.length - 1];
        i = height.length - 2;
        while (i >= 0) {
            if (height[i] > y[i + 1]) {
                y[i] = height[i];
            } else {
                y[i] = y[i + 1];
            }
            i--;
        }

        int re = 0;
        i = 0;
        while (i < d.length) {
            int x = Math.min(d[i], y[i]);
            int sub = x - height[i];
            if (sub > 0) {
                re += sub;
            }
            i++;
        }

        return re;
    }

}
