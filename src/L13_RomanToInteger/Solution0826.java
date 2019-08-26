package L13_RomanToInteger;


import java.util.HashMap;

public class Solution0826 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int a = romanToInt(s);
        System.out.println(a);

    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int pre = 0;
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int cur = map.get(ch);

            sum += cur;
            if (cur > pre) {
                sum = sum - 2 * pre;
            }
            pre = cur;

            i++;
        }

        return sum;
    }

}
