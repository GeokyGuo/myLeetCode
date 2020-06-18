package firstRound.L67_AddBinary;

public class Solution0718 {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
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
        int c = 0;
        int y = 0;
        int sum = 0;
        char[] re = new char[ai > bi ? (ai + 2) : (bi + 2)];  //第一个错误是长度算错了
        int rei = re.length - 1;

        while (ai > -1 && bi > -1) {
            int aint = a.charAt(ai) - '0';      //注意 int 与char的转换
            int bint = b.charAt(bi) - '0';

            sum = aint + bint + c;

            c = sum / 2;
            y = sum % 2;

            re[rei] = (char) (y + '0');   //注意 int 与char的转换
            ai--;
            bi--;
            rei--;
        }
        while (ai > -1) {
            int aint = a.charAt(ai) - '0';


            sum = aint + c;

            c = sum / 2;
            y = sum % 2;

            re[rei] = (char) (y + '0');
            ai--;
            rei--;
        }
        while (bi > -1) {
            int bint = b.charAt(bi) - '0';


            sum = bint + c;

            c = sum / 2;
            y = sum % 2;

            re[rei] = (char) (y + '0');
            bi--;
            rei--;
        }
        if (c == 1) {
            re[0] = '1';    //第二个错误是 应该存 char的 但存成了int，！！
            return new String(re);   //第三个遗忘的点 是， 如果倒序 输出的话  不知道怎么输出， 初步方案是弄一个char数组，然后组成string，然后还可以截取
        } else {
            return new String(re).substring(1);
        }

    }
}
