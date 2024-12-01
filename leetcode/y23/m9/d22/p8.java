package y23.m9.d22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。

 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。



 示例1:

 输入: pattern = "abba", s = "dog cat cat dog"
 输出: true

 示例 2:

 输入:pattern = "abba", s = "dog cat cat fish"
 输出: false

 示例 3:

 输入: pattern = "aaaa", s = "dog cat cat dog"
 输出: false



 提示:


 1 <= pattern.length <= 300
 pattern只包含小写英文字母
 1 <= s.length <= 3000
 s只包含小写英文字母和' '
 s不包含 任何前导或尾随对空格
 s中每个单词都被 单个空格 分隔


 */
/*
https://leetcode.cn/problems/word-pattern/?envType=study-plan-v2&envId=top-interview-150
*/
    class Solutionp8 {
        public boolean wordPattern(String pattern, String s) {
            char[] cp = pattern.toCharArray();
            String[] words = s.split(" ");
            int len=pattern.length();
            if (words.length!=len)
                return false;
            Map<Character,String> map=new HashMap<>();
            Set<String> used=new HashSet<>();
            for (int i=0;i<len;++i){
                if (!map.containsKey(cp[i])){
                    map.put(cp[i],words[i]);
                    if (used.contains(words[i]))
                        return false;
                    used.add(words[i]);
                }else {
                    if (!map.get(cp[i]).equals(words[i]))
                        return false;
                }
            }
            return true;
        }
    }