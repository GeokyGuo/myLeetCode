package firstRound.L42_TrappingRainWater;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[][] re = trap(height);
        for (int i = 0; i < re.length; i++) {
            System.out.println(Arrays.toString(re[i]));

        }
    }

    public static int[][] trap(int[] height) {
        int[] d = new int[height.length];//从前往后 第i个左边的最大值
        int[] x = new int[height.length];//从后往前，第i个右边的最大值

        d[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > d[i - 1]) {
                d[i] = height[i - 1];
            } else {
                d[i] = d[i - 1];
            }
        }

        x[x.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > -1; i--) {
            if (height[i + 1] > x[i + 1]) {
                x[i] = height[i + 1];
            } else {
                x[i] = x[i + 1];
            }
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int min = Math.min(d[i], x[i]);
            int sub = min - height[i];
            if (sub > 0) {
                sum += sub;
            }
        }

        int[][] re = new int[3][height.length];
        re[0] = d;
        re[1] = x;
        re[2] = new int[]{sum};
        return re;
    }
}
