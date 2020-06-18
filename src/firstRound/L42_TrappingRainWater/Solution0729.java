package firstRound.L42_TrappingRainWater;

import java.util.Arrays;

public class Solution0729 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[][] re = trap(height);
        for (int i = 0; i < re.length; i++) {
            System.out.println(Arrays.toString(re[i]));

        }
    }

    public static int[][] trap(int[] height) {
        if(height.length==0){

            return null;
        }
        int[] d = new int[height.length]; //i这个位置前的最大值是几
        int[] x = new int[height.length];// 这个最大值的坐标是啥


        d[0] = height[0];
        int i = 1;
        while (i < height.length) {
            if (height[i - 1] > d[i - 1]) {
                d[i] = height[i - 1];
            } else {
                d[i] = d[i - 1];
            }
            i++;
        }

        x[x.length - 1] = height[height.length - 1];
        i = height.length - 2;
        while (i > -1) {
            if (height[i + 1] > x[i + 1]) {
                x[i] = height[i + 1];
            } else {
                x[i] = x[i + 1];
            }
            i--;
        }

        i = 0;
        int sum = 0;
        while (i < height.length) {
            int a = Math.min(d[i], x[i]);
            int sub = a - height[i];

            if (sub > 0) {
                sum += sub;
            }
            i++;
        }
        int[][] re = new int[3][height.length];
        re[0] = d;
        re[1] = x;
        re[2] = new int[]{sum};
        return re;
    }
}
