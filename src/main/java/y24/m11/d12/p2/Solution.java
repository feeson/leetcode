package y24.m11.d12.p2;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findLUSlength(String a, String b) {
        return Math.max(max(a, b), max(b, a));
    }
    int max(String a, String b){
        Set<Character> dic = new HashSet<>();
        for(char c:a.toCharArray()){
            dic.add(c);
        }
        int remain = b.length();
        for(char c:b.toCharArray()){
            if(dic.contains(c)){
                remain--;
            }
        }
        if(remain == 0)
            return -1;
        return remain;
    }
}