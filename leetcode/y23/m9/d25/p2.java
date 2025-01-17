package y23.m9.d25;

import java.util.Arrays;

/**
 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。



 示例1:

 输入: s = "anagram", t = "nagaram"
 输出: true


 示例 2:

 输入: s = "rat", t = "car"
 输出: false



 提示:


 1 <= s.length, t.length <= 5 * 104
 s 和 t仅包含小写字母




 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

 */
/*
https://leetcode.cn/problems/valid-anagram/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp2 {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false;
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int[]times1=new int[26];
        int[]times2=new int[26];
        for (char c:arr1){
            times1[c-'a']++;
        }
        for (char c:arr2){
            times2[c-'a']++;
        }
        for (int i=0;i<times1.length;++i){
            if (times2[i]!=times1[i])
                return false;
        }
        return true;
    }
}