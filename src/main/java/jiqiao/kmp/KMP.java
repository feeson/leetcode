package jiqiao.kmp;

import java.util.Arrays;

public class KMP {
    String pattern;
    String str;
    int len;
    void init(String pattern, int[] next){
        int len = pattern.length();
        next[0] = 0;
        int j = 0;
        for (int i = 0; i < len; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = next[j - 1];
            if (pattern.charAt(i) == pattern.charAt(j)) j++;
            next[i] = j;
        }
    }
    int eval(String search,String pattern, int[] next) {
        int j = 0;
        int len = search.length();
        for (int i = 0; i < len; i++) {
            while (j > 0 && search.charAt(i) != pattern.charAt(j)) j = next[j - 1];
            if (pattern.charAt(j) == search.charAt(i)) j++;
            if (j == next.length) return i;
        }
        return -1;
    }
}
