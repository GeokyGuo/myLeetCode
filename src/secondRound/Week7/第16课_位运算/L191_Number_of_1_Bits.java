package secondRound.Week7.第16课_位运算;

public class L191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }


    // you need to treat n as an unsigned value
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}

//方法一 是位移每一位
//方法二 是用到 n & (n - 1)  这个操作，即去掉最后一个1
