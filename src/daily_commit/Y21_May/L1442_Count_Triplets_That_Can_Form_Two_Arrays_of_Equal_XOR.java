package daily_commit.Y21_May;

public class L1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    public int countTriplets(int[] arr) {
        int count = 0;
        //构造异或前缀
        int[] prexor = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prexor[i + 1] = prexor[i] ^ arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                if(prexor[k + 1] == prexor[i]) count += k-i;
            }
        }
        return count;
    }
}
//知识点1
//异或前缀数组
//还可以优化成o（n）
//https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/solution/xin-shou-pian-qian-ru-shen-chu-xi-lie-1-cnk37/
