package y23.m2.d27;

import java.util.ArrayList;

/**
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 *
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-binary-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int countBinarySubstrings(String s) {
        int len=s.length();
        int res=0;
        int last=0;
        int tmp=1;
        for (int i=0;i<len-1;++i){
            if (s.charAt(i)==s.charAt(i+1)){
                tmp++;
            }else {
                res+=Integer.min(tmp,last);
                last=tmp;
                tmp=1;
            }
        }
        res+=Integer.min(tmp,last);
        return res;
    }
}