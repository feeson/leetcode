package y23.m9.d8;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。



 示例1:

 输入: s = "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。


 示例 2:

 输入: s = "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。


 示例 3:

 输入: s = "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。




 提示：


 0 <= s.length <= 5 * 104
 s由英文字母、数字、符号和空格组成


 */
/*
https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
*/
class Solution04 {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if (len==0||len==1)
            return s.length();
        int right=0,res=0;
        char[] charArray = s.toCharArray();
        int[]cnt=new int[128];
        for (int left=0;left< len;++left){
            while (right<len&&cnt[charArray[right]]==0){
                ++cnt[charArray[right++]];
            }
            res=Math.max(res,right-left);
            --cnt[charArray[left]];
        }
        return res;
    }
}