package L42_TrappingRainWater;

import java.util.Arrays;

public class Solution0819 {


    /**
     * 贼蠢1  二维数组竟然不知道怎么赋值
     * 贼蠢2  (height[i + 1] > x[i + 1]  反着赋值的时候 粗心把X 意淫成D
     * 贼蠢3 在最后统计的时候 竟然写成  re = re+ d[i],,  应该是加 差值
     *
     */
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[][] re = trap(height);
        for (int i = 0; i < re.length; i++) {
            System.out.println(Arrays.toString(re[i]));

        }
//        int re = trap(height);
//        System.out.println(re);
    }

    public static int[][] trap(int[] height) {
        if (height == null || height.length == 0) {
            return null;
        }

        int[] d = new int[height.length];
        int[] x = new int[height.length];

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
        i = x.length - 2;
        while (i > -1) {
            if (height[i + 1] > x[i + 1]) {
                x[i] = height[i + 1];
            } else {
                x[i] = x[i + 1];
            }
            i--;
        }
        int re = 0;
        i = 0;
        while (i < d.length) {
            int a = Math.min(x[i], d[i]);
            int sub = a - height[i];
            if (sub > 0) {
                re += sub;
            }
            i++;
        }

        int[][] rea = new int[4][height.length];

        rea[0] = d;
        rea[1] = x;
        rea[2] = height;
        rea[3][0] = re;
        return rea;
    }
}
