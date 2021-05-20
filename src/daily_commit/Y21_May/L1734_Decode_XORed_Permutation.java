package daily_commit.Y21_May;

public class L1734_Decode_XORed_Permutation {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] ans = new int[n];

        int a = 0;
        for(int i = 1; i < encoded.length; i += 2){
            a ^= encoded[i];
        }
        int b =0;
        for (int i = 1; i < n + 1; i++) {
            b ^= i;
        }
        ans[0] = a ^ b;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] ^ encoded[i - 1];
        }
        return ans;
    }
}
