package firstRound.L67_AddBinary;

public class Solution {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        String s = addBinary(a, b);
        System.out.println(s);

    }

    public static String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int ai = alen - 1;
        int bi = blen - 1;
        char[] re = new char[alen > blen ? (alen + 1) : (blen + 1)];

        int flag = 0;
        int k = re.length - 1;
        while (ai >= 0 && bi >= 0) {
            if (flag == 0) {
                if (a.charAt(ai) == '1' && b.charAt(bi) == '1') {
                    re[k--] = '0';
                    flag = 1;
                } else if (a.charAt(ai) == '0' && b.charAt(bi) == '0') {
                    re[k--] = '0';
                    flag = 0;
                } else {
                    re[k--] = '1';
                    flag = 0;
                }
                ai--;
                bi--;
            } else if (flag == 1) {
                if (a.charAt(ai) == '1' && b.charAt(bi) == '1') {
                    re[k--] = '1';
                    flag = 1;
                } else if (a.charAt(ai) == '0' && b.charAt(bi) == '0') {
                    re[k--] = '1';
                    flag = 0;
                } else {
                    re[k--] = '0';
                    flag = 1;
                }
                ai--;
                bi--;
            }

        }

        while (ai >= 0) {
            if (flag == 0) {
                re[k--] = a.charAt(ai);
                flag = 0;
            } else {
                if (a.charAt(ai) == '0') {
                    re[k--] = '1';
                    flag = 0;
                } else {
                    re[k--] = '0';
                    flag = 1;
                }
            }
            ai--;
        }
        while (bi >= 0) {
            if (flag == 0) {
                re[k--] = b.charAt(bi);
                flag = 0;
            } else {
                if (b.charAt(bi) == '0') {
                    re[k--] = '1';
                    flag = 0;
                } else {
                    re[k--] = '0';
                    flag = 1;
                }
            }
            bi--;
        }

        if (flag == 1) {
            re[0] = '1';
            return new String(re);
        } else {
            return new String(re).substring(1);
        }

    }
}
