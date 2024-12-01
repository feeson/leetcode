package y22.m09.d28.p2;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==1){
            return 1;
        }else {
            int cur=0;
            int Max=0;
            Queue<Character> queue=new LinkedList<>();
            for (int i=0; i < s.length(); ++i){
                if (queue.contains(s.charAt(i))){
                    while (queue.contains(s.charAt(i))){
                        queue.remove();
                        cur--;
                    }
                }
                cur++;
                queue.add(s.charAt(i));
                Max=Math.max(cur,Max);
            }
            return Max;
        }
    }
}
