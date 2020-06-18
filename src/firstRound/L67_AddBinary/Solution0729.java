package firstRound.L67_AddBinary;

public class Solution0729 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1110";
        String s = addBinary(a, b);
        System.out.println(s);
//        int y = 1;
//        char c = (char) (y + '0');
//
//
//        System.out.println(c);


    }

    public static String addBinary(String a, String b) {
        int ai = a.length() - 1;
        int bi = b.length() - 1;

        int inta;
        int intb;

        int c = 0;
        int y;

        char[] re = new char[ai > bi ? ai + 2 : bi + 2];
        int i = re.length - 1;

        while (ai > -1 && bi > -1) {

            inta = a.charAt(ai) - '0';
            intb = b.charAt(bi) - '0';

            y = (inta + intb + c) % 2;
            c = (inta + intb + c) / 2;
            re[i] = (char) (y + '0');
            i--;
            ai--;
            bi--;

        }
        while (ai > -1) {
            inta = a.charAt(ai) - '0';
            y = (inta + c) % 2;
            c = (inta + c) / 2;
            re[i] = (char) (y + '0');
            i--;
            ai--;
        }
        while (bi > -1) {
            intb = b.charAt(bi) - '0';
            y = (intb + c) % 2;
            c = (intb + c) / 2;
            re[i] = (char) (y + '0');
            i--;
            bi--;
        }


        if (c == 0) {
            return new String(re).substring(1);

        } else {
            re[0] = (char) (c + '0');
            return new String(re);
        }

    }
}
