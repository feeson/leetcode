package y23.m5.d6;

import java.util.*;

/**
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。
 *
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-frogs-croaking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character,Integer> frogs=new HashMap<>();
        frogs.put('c',0);
        frogs.put('r',0);
        frogs.put('o',0);
        frogs.put('a',0);
        frogs.put('k',0);
        int len=croakOfFrogs.length();
        int res=0;
//        var t='c';

        for (int i=0;i<len;++i){
            char c=croakOfFrogs.charAt(i);
            boolean ctn=false;
            if (frogs.get(c)>0){
                ctn=true;
                frogs.replace(c,frogs.get(c)-1);
            }

            if (ctn)
                continue;
            if (c!='c')
                return -1;
//            int t=0;
//            t=Integer.max(t,frogs.get('c'));
//            t=Integer.max(t,frogs.get('r'));
//            t=Integer.max(t,frogs.get('o'));
//            t=Integer.max(t,frogs.get('a'));
//            t=Integer.max(t,frogs.get('k'));
//            res=Integer.max(res,t+1);
//            frogs.put('r',frogs.get('r')+1);
//            frogs.put('o',frogs.get('o')+1);
//            frogs.put('a',frogs.get('a')+1);
//            frogs.put('k',frogs.get('k')+1);
//
        }
//        if (frogs.get('c')!=0||frogs.get('r')!=0||frogs.get('o')!=0||frogs.get('a')!=0||frogs.get('k')!=0)
//            return -1;
        return res;
    }
}