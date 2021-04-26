package secondRound.Week8.第20课_字符串算法;

import java.util.ArrayList;
import java.util.List;

public class L438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();

        // Set<String> set = new HashSet<>();
        String hashP = getHash(p);
        // set.add(hashP);

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String subS = s.substring(i, i + p.length());
            String hashSubS = getHash(subS);
            // if(set.contains(hashSubS)){
            // resList.add(i);
            // }
            if (hashSubS.equals(hashP)) {
                resList.add(i);
            }
        }
        return resList;
    }

    String getHash(String str) {
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (int i : arr) {
            sb.append(i + "#");
        }
        return sb.toString();
    }
}
