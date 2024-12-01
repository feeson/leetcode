package y24.m5.d5.p6;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] supply = new char[26];
        char[] need = new char[26];
        for (char c:magazine.toCharArray()){
            supply[c - 'a']++;
        }
        for (char c:ransomNote.toCharArray()){
            need[c - 'a']++;
        }
        for (int i = 0;i < 26; ++i){
            if (supply[i] < need[i])
                return false;
        }
        return true;
    }
}