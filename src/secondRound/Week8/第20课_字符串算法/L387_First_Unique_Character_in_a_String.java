package secondRound.Week8.第20课_字符串算法;

import java.util.HashMap;
import java.util.Map;

public class L387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int i = 0;
        for (char ch : s.toCharArray()) {
            if (map.get(ch) == 1) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
