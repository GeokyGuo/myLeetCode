package secondRound.Week2.第08课_分治_回溯;

import java.util.*;

public class L17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {

    }

    Map<Character, String> map = new HashMap<>();
    List<String> reList = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return reList;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        builder(digits, "", 0);

        return reList;
    }

    void builder(String digits, String s, int index) {
        if (s.length() == digits.length()) {
            reList.add(s);
            return;
        }

        char ch = digits.charAt(index);
        String str = map.get(ch);
        for (int j = 0; j < str.length(); j++) {
            builder(digits, s + str.charAt(j), index + 1);
        }
    }


}

