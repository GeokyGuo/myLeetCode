package secondRound.Week3.第10课_贪心算法;

import java.util.Arrays;

public class L455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0; int si = 0;
        while(gi < g.length && si < s.length){
            if(s[si] >= g[gi]){
                gi++;
            }
            si++;
        }
        return gi;
    }
}

//大饼干更加万能