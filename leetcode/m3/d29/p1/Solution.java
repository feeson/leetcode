package y24.m3.d29.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int len = s.length();
        int plen = p.length();
        if (plen > len)
            return new ArrayList<>();
        int[] pattern = new int[26];
        for (int i = 0;i < plen; ++i){
            pattern[p.charAt(i) - 'a']++;
        }
        int need = 0;
        for (int i = 0;i < 26;++i){
            if (pattern[i] != 0)
                need++;
        }
        int[] cnt = new int[26];
        for (int i = 0;i < plen;++i){
            cnt[s.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = plen - 1;
        while (r<len){
            int fit = 0;
            for (int i = 0;i < 26;++i){
                if (cnt[i] == pattern[i] && cnt[i] != 0)
                    fit++;
            }
            if (fit == need)
                res.add(l);
            r++;
            if (r < len){
                int cr = s.charAt(r) - 'a';
                cnt[cr]++;
            }else
                break;

            int cl = s.charAt(l) - 'a';
            cnt[cl]--;
            l++;

        }
        return res;
    }
}
class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams("abab","ab");
    }
}