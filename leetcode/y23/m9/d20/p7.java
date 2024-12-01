package y23.m9.d20;

import java.security.KeyManagementException;

/**
 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。



 示例 1：

 输入：haystack = "sadbutsad", needle = "sad"
 输出：0
 解释："sad" 在下标 0 和 6 处匹配。
 第一个匹配项的下标是 0 ，所以返回 0 。


 示例 2：

 输入：haystack = "leetcode", needle = "leeto"
 输出：-1
 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。




 提示：


 1 <= haystack.length, needle.length <= 104
 haystack 和 needle 仅由小写英文字符组成


 */
/*
https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp7 {
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        haystack=" "+haystack;
        needle=" "+needle;
        int[] kmp=new int[len2+1];
        for (int i=2,j=0;i<=len2;++i){
            while (j>0&&needle.charAt(j+1)!=needle.charAt(i))j=kmp[j];
            if (needle.charAt(i)==needle.charAt(j+1))j++;
            kmp[i]=j;
        }
        for (int i=1,j=0;i<=len1;++i){
            while (j>0&&haystack.charAt(i)!=needle.charAt(j+1))j=kmp[j];
            if (haystack.charAt(i)==needle.charAt(j+1))j++;
            if (j==len2)return i-len2;
        }
        return -1;
    }
}