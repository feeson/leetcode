package y23.m9.d25;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



 示例 1:

 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

 示例 2:

 输入: strs = [""]
 输出: [[""]]


 示例 3:

 输入: strs = ["a"]
 输出: [["a"]]



 提示：


 1 <= strs.length <= 104
 0 <= strs[i].length <= 100
 strs[i]仅包含小写字母


 */
/*
https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Long,List<String>> map=new HashMap<>();
        int[] t=new int[26];
        for (String s:strs){
            Arrays.fill(t,0);
            int len=s.length();
            for (int i=0;i<len;++i){
                t[s.charAt(i)-'a']++;
            }
            long hashCode=0;
            long base=1;
            for (int i=0;i<26;++i){
                if (t[i]!=0)
                    hashCode+=base* t[i];
                base*=101;
            }
            if (map.containsKey(hashCode))
                map.get(hashCode).add(s);
            else{
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(hashCode,list);
            }
        }
        return new ArrayList<>(map.values());
    }

//    public static void main(String[] args) {
//        String[]arr=new String[]{"eat","tea","tan","ate","nat","bat"};
//        Solution solution=new Solution();
//        solution.groupAnagrams(arr);
//    }
}