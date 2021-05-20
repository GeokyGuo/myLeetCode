package daily_commit.Y21_April;

import java.util.HashSet;
import java.util.Set;

public class L403_Frog_Jump {
    public static void main(String[] args) {
        int[] stones = {0, 1, 2, 3, 4, 5, 999};
        int[] stones1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,26,27,28,29,30,31,32,33,34,35,99999999};
        canCross(stones1);
    }

    public static boolean canCross(int[] stones) {
        if (stones.length < 2 || stones[0] != 0 || stones[1] != 1) return false;
        return helper1(new HashSet<String>(), stones, 1, 1);
    }

    static boolean helper(Set<String> set, int[] stones, int index, int k) {
        String keyStr = String.valueOf(index) + "-" + String.valueOf(k);
        if (set.contains(keyStr)) return false;
        else set.add(keyStr);

        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if (gap >= k - 1 && gap <= k + 1) {
                boolean res = helper(set, stones, i, gap);
                if (res == true) return true;
            } else if (gap > k + 1) break;
        }
        return (index == stones.length - 1);
    }

    static boolean helper1(Set<String> set, int[] stones, int index, int k) {
//        String keyStr = String.valueOf(index) + "-" + String.valueOf(k);
//        if (set.contains(keyStr)) return false;
//        else set.add(keyStr);
        System.out.println(index + " " + k);
        for (int i = index + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[index];
            if (gap >= k - 1 && gap <= k + 1) {
                boolean res = helper1(set, stones, i, gap);
                if (res == true) return true;
            } else if (gap > k + 1) break;
        }
        return (index == stones.length - 1);
    }
}
//https://leetcode-cn.com/problems/frog-jump/solution/shou-hua-tu-jie-ji-hao-de-di-gui-ti-man-8kk2z/
//这篇答案让我明白，回溯for的含义是在扩宽 递归树， 继续递归是在加深递归树， 然后就要在合适的位置剪枝，并且一旦出现 重复性的超时，要有记忆化的搜索，
//    重复模块不是说一直在绕圈子出不来，二十说重复的分支过于多，有些节点要重复计算，如果给的时间足够多，不用记忆一直计算 最终也是可以算出来