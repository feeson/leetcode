package y23.m3.d9;

import javax.swing.*;
import java.security.KeyPair;
import java.util.*;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 *
 * 实现 MagicDictionary 类：
 *
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/US1pGT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MagicDictionary {

    /** Initialize your data structure here. */
    Map<String,Map<Integer,Character>> map=new HashMap<>();
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        for (int i=0;i<dictionary.length;++i){
            String str=dictionary[i];
            for (int j=0;j<str.length();++j){
                StringBuilder sb=new StringBuilder(str);
                String tmp= String.valueOf(sb.replace(j, j+1, ""));
                if (map.containsKey(tmp)){
                    Map map1= map.get(tmp);
                    if (map1.containsKey(j)){
                        map1.replace(j,null);
                        map.replace(tmp,map1);
                    }else {
                        map1.put(j,str.charAt(j));
                        map.replace(tmp,map1);
                    }
                }else {
                    Map map1=new HashMap();
                    map1.put(j,str.charAt(j));
                    map.put(tmp,map1);
                }
            }
        }
    }

    public boolean search(String searchWord) {
        for (int i=0;i<searchWord.length();++i){
            StringBuilder sb=new StringBuilder(searchWord);
            String str= String.valueOf(sb.replace(i, i+1, ""));
            if (map.containsKey(str)){
                Map map1=map.get(str);
                if (map1.containsKey(i)){
                    if (map1.get(i)==null)
                        return true;
                    else{
                        if ((Character) map1.get(i)!=searchWord.charAt(i)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */