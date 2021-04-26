package secondRound.Week8.第20课_字符串算法;

public class L242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        for(char ch : t.toCharArray()){
            arr[ch-'a']--;
        }
        for(int i : arr){
            if(i != 0) return false;
        }
        return true;
    }
}
