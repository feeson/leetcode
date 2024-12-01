package y23.m9.d22;

import java.util.Arrays;

/**
 给定两个字符串s和t，判断它们是否是同构的。

 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。

 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。



 示例 1:

 输入：s = "egg", t = "add"
 输出：true


 示例 2：

 输入：s = "foo", t = "bar"
 输出：false

 示例 3：

 输入：s = "paper", t = "title"
 输出：true



 提示：




 1 <= s.length <= 5 * 104
 t.length == s.length
 s和t由任意有效的 ASCII 字符组成


 */
/*
https://leetcode.cn/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp7 {
    public boolean isIsomorphic(String s, String t) {
        int[]toIndexS=new int[128];
        int[]toIndexT=new int[128];
        Arrays.fill(toIndexS,-1);
        Arrays.fill(toIndexT,-1);
        int len=s.length();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int csIndex=0,ctIndex=0;
        for (int i=0;i<len;++i){
            char charS=cs[i];
            char charT=ct[i];
            int t1,t2;
            if (toIndexS[charS] == -1) {
                toIndexS[charS] = csIndex++;
            }
            t1=toIndexS[charS];
            if (toIndexT[charT] == -1) {
                toIndexT[charT] = ctIndex++;
            }
            t2=toIndexT[charT];
            if (t1!=t2)
                return false;
        }
        return true;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        String s="ab";
//        String t="aa";
//        System.out.println(solution.isIsomorphic(s,t));
//    }
}