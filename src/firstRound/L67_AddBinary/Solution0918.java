package firstRound.L67_AddBinary;

public class Solution0918 {
    public static void main(String[] args) {
        String a = "0";
        String b = "0";
        String s = addBinary(a, b);
        System.out.println(s);

    }

    public static String addBinary(String a, String b) {

        int yu = 0;
        int c = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuffer sb = new StringBuffer();

        while (i >= 0 && j >= 0) {
            int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + c;
            c = sum / 2;
            yu = sum % 2;
            sb.insert(0, yu);

            i--;
            j--;
        }

        while (i >= 0) {
            int sum = (a.charAt(i) - '0') + c;
            c = sum / 2;
            yu = sum % 2;

            sb.insert(0, yu);

            i--;
        }

        while (j >= 0) {
            int sum = (b.charAt(j) - '0') + c;
            c = sum / 2;
            yu = sum % 2;

            sb.insert(0, yu);

            j--;
        }

        if (c > 0) {
            return sb.insert(0, 1).toString();
        } else {
            return sb.toString();
        }
    }
}
