package 复习一轮;

import java.util.Arrays;

public class test10 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }


    public int jump(int[] nums) {


        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return count + 1;
            }

            int jumpStep = 0;
            int max = 0;
            for (int j = 0; j <= nums[i]; j++) {
                int newCur = i + j;
                if (nums[newCur] + j > max) {
                    max = nums[newCur] + j;
                    jumpStep = j;
                }
            }
            i = i + jumpStep;
            count++;
            if (i == nums.length - 1) break;

        }
        return count;
    }

}
