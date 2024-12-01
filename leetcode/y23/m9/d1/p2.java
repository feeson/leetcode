package y23.m9.d1;

import java.util.*;

/**
 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



 注意：


 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 如果 s 中存在这样的子串，我们保证它是唯一的答案。




 示例 1：

 输入：s = "ADOBECODEBANC", t = "ABC"
 输出："BANC"
 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。


 示例 2：

 输入：s = "a", t = "a"
 输出："a"
 解释：整个字符串 s 是最小覆盖子串。


 示例 3:

 输入: s = "a", t = "aa"
 输出: ""
 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 因此没有符合条件的子字符串，返回空字符串。



 提示：


 m == s.length
 n == t.length
 1 <= m, n <= 105
 s 和 t 由英文字母组成



 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
/*
https://leetcode.cn/problems/minimum-window-substring/
*/
class Solution {
    public String minWindow(String s, String t) {
        //不断寻找最小符合要求字串
        Map<Character,Integer> need=new HashMap<>();//key:char val:需要的数量
        //处理需求
        for (int i=0;i<t.length();++i){
            char c=t.charAt(i);
            if (need.containsKey(c)){
                need.replace(c,need.get(c)+1);
            }else {
                need.put(c,1);
            }
        }
        Map<Character,Integer> found=new HashMap<>();
        Map<Character,Integer> helpFound=new HashMap<>(need);
        int leftValid=0;
        while (leftValid<s.length()&&!need.containsKey(s.charAt(leftValid))){
            leftValid++;
        }
        if (leftValid==s.length())
            return "";
        //寻找第一个完全有效的数组
        int rightValid=-1;
        Deque<Integer> nextIndex=new LinkedList<>();
        for (int i=leftValid;i<s.length();++i){
            char c=s.charAt(i);
            if (need.containsKey(c)){
                nextIndex.add(i);
                if (found.containsKey(c)){
                    found.replace(c,found.get(c)+1);
                }else {
                    found.put(c,1);
                }
                if (helpFound.containsKey(c)){
                    helpFound.replace(c,helpFound.get(c)-1);
                    if (helpFound.get(c)==0){
                        helpFound.remove(c);
                        if (helpFound.size()==0){
                            rightValid=i;
                            break;
                        }
                    }
                }
            }
        }
        if (rightValid==-1)
            return "";
        int resl=leftValid;
        int resr=rightValid;
        nextIndex.poll();
        while (found.get(s.charAt(leftValid))>need.get(s.charAt(leftValid))){
            found.replace(s.charAt(leftValid),found.get(s.charAt(leftValid))-1);
            leftValid= nextIndex.poll();
            if (rightValid-leftValid<resr-resl){
                resr=rightValid;
                resl=leftValid;
            }
        }


        for (int i=rightValid+1;i<s.length();++i){
            char c=s.charAt(i);
            if (need.containsKey(c)){
                found.replace(c,found.get(c)+1);
                nextIndex.add(i);
                while (found.get(s.charAt(leftValid))>need.get(s.charAt(leftValid))){
                    found.replace(s.charAt(leftValid),found.get(s.charAt(leftValid))-1);
                    leftValid= nextIndex.poll();
                }
                rightValid=i;
                if (rightValid-leftValid<resr-resl){
                    resr=rightValid;
                    resl=leftValid;
                }
            }
        }
        return s.substring(resl,resr+1);
    }
}