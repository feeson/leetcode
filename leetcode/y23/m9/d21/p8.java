package y23.m9.d21;

import y23.m9.d4.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 给定一个字符串s和一个字符串数组words。words中所有字符串 长度相同。

 s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。


 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，因为他不是任何words排列的连接。


 返回所有串联子串在s中的开始索引。你可以以 任意顺序 返回答案。



 示例 1：

 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 输出：[0,9]
 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 输出顺序无关紧要。返回 [9,0] 也是可以的。


 示例 2：

 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 输出：[]
 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 所以我们返回一个空数组。


 示例 3：

 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 输出：[6,9,12]
 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。



 提示：


 1 <= s.length <= 104
 1 <= words.length <= 5000
 1 <= words[i].length <= 30
 words[i]和s 由小写英文字母组成


 */
/*
https://leetcode.cn/problems/substring-with-concatenation-of-all-words/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp8 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wlen=words[0].length();
        int len=words.length;
        int slen=s.length();
        Map<String,Integer> map=new HashMap<>();
        for (String str:words){
            if (map.containsKey(str))
                map.replace(str,map.get(str)+1);
            else
                map.put(str,1);
        }
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<wlen;++i){
            int left=i;
            int right=left+wlen*len;
            Map<String,Integer>used=new HashMap<>();
            int validCnt=0;
            while (right<=slen){
                if (used.size()==0){
                    int t=left;
                    while (t<=right-wlen){
                        String toPattern=s.substring(t,t+wlen);
                        validCnt = getValidCnt(map, used, validCnt, toPattern);
                        t+=wlen;
                    }
                }
                if (validCnt==len)
                    res.add(left);
                if ((right+=wlen)<=slen){
                    String toRmv=s.substring(left,left+wlen);
                    if (used.containsKey(toRmv)){
                        used.replace(toRmv,used.get(toRmv)-1);
                        if (used.get(toRmv)<map.get(toRmv))
                            validCnt--;
                    }
                    left+=wlen;
                    String toApd=s.substring(right-wlen,right);
                    validCnt = getValidCnt(map, used, validCnt, toApd);
                }
            }
        }
        return res;
    }

    private int getValidCnt(Map<String, Integer> map, Map<String, Integer> used,
                            int validCnt, String toApd) {
        if (map.containsKey(toApd)){
            if (!used.containsKey(toApd)){
                used.put(toApd,1);
                validCnt++;
            }else {
                used.replace(toApd,used.get(toApd)+1);
                if (used.get(toApd)<=map.get(toApd))
                    validCnt++;
            }
        }
        return validCnt;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        String s="barfoofoobarthefoobarman";
//        String[] words=new String[]{"bar","foo","the"};
//        System.out.println(solution.findSubstring(s,words));
//    }
}
