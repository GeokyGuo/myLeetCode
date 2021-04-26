package secondRound.Week8.第20课_字符串算法;

public class L709_To_Lower_Case {
    public String toLowerCase(String str) {
        char[] newStr = new char[str.length()];
        for(int i = 0; i < str.length();i++){
            char temp = str.charAt(i);
            int sub = temp - 'A';
            if (sub >= 0) {
                newStr[i] = (char)('a' + sub);
            } else {
                newStr[i] = temp;
            }

        }
        return String.valueOf(newStr);
    }
}

//a 在A 后边
//字符数组变成字符串的方法  String.valueOf
