package y24.m3.d26.p4;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int compare(String str1,String str2){
        if (str1.length() != str2.length())
            return 3;
        int diff = 0;
        for (int i = 0;i < str1.length();++i){
            if (str1.charAt(i) != str2.charAt(i)){
                diff++;
                if (diff >= 3)
                    return 3;
            }
        }
        return diff;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for (String str:queries){
            boolean add = false;
            for (String pat:dictionary){
                int compare = compare(str, pat);
                if (compare <= 2){
                    add = true;
                    break;
                }
            }
            if (add)
                res.add(str);
        }
        return res;
    }
}