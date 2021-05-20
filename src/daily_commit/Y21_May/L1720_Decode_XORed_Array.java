package daily_commit.Y21_May;

public class L1720_Decode_XORed_Array {
    public int[] decode(int[] encoded, int first) {
        // ans[i]^ans[i + 1] = encoded[i];
        // ans[i +1] = ans[i] ^ encoded[i]
        int n = encoded.length + 1;
        int[] ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
//异或的特点是
//任何值 异或0 都等于它本身
//任何值与本身异或 都等于0
//满足交换律
