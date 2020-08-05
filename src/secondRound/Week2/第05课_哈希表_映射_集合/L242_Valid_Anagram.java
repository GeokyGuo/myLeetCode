package secondRound.Week2.第05课_哈希表_映射_集合;

import java.util.Arrays;

public class L242_Valid_Anagram {
    public static void main(String[] args) {

    }

    //方法1  排序后比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    //方法2  hash table
    public boolean isAnagram2(String s, String t) {
        int[] hashTable = new int[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            hashTable[index] += 1;

        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            hashTable[index] -= 1;
        }
        for (int i : hashTable) {
            if (i != 0) return false;
        }
        return true;
    }

    //标准 参考
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) return false;
        }
        return true;
    }


}
