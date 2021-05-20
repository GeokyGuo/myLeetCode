package daily_commit.Y21_April;

public class L137_Single_Number_II {
    public int singleNumber(int[] nums) {
        int x = 0, y = 0;
        int temp;
        for (int i : nums) {
            temp = (~i & x) | (i & y);
            y = (~i & y) | (i & ~x & ~y);
            x = temp;
        }
        return y;
    }
}

//核心思想是定义出状态，最后结果是由状态推出 某个单独的数字
//然后写出状态的真值表， 并化出状态的卡诺图
//https://leetcode-cn.com/problems/single-number-ii/solution/zhi-chu-xian-yi-ci-de-shu-zi-ii-shu-zi-dian-lu-she/
//https://leetcode-cn.com/problems/single-number-ii/solution/luo-ji-dian-lu-jiao-du-xiang-xi-fen-xi-gai-ti-si-l/


//类似题目 222  1 1 这种组合中 找出1 1 的数值具体是几？
//https://mp.weixin.qq.com/s?__biz=MzUyNjQxNjYyMg==&mid=2247484505&idx=1&sn=4c1c056dd4852c3b4b1ead51c90a9b2d&chksm=fa0e6bd8cd79e2ce8188dcdd8843a5d071248906bfb8971c62d513dbd69b816acc191a78e4b2&scene=21#wechat_redirect

