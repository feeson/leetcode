package y23.m11.d9;

import java.util.HashSet;
import java.util.Set;

/**
 给你一个字符串text ，请你返回满足下述条件的不同 非空子字符串的数目：


 可以写成某个字符串与其自身相连接的形式（即，可以写为 a+ a，其中 a 是某个字符串）。


 例如，abcabc就是abc和它自身连接形成的。



 示例 1：

 输入：text = "abcabcabc"
 输出：3
 解释：3 个子字符串分别为 "abcabc"，"bcabca" 和 "cabcab" 。


 示例 2：

 输入：text = "leetcodeleetcode"
 输出：2
 解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。




 提示：


 1 <= text.length <= 2000
 text只包含小写英文字母。


 */
/*
https://leetcode.cn/problems/distinct-echo-substrings/
*/
class Solution {
    int[] getPmt(String pat){
        int len=pat.length();
        int[] arr=new int[len];
        char[] charArray = pat.toCharArray();
        for (int j=1,k=0;j<len;++j){
            while (k>0&&charArray[j]!=charArray[k])k=arr[k-1];
            if (charArray[j]==charArray[k])k++;
            arr[j]=k;
        }
        return arr;
    }
    public int distinctEchoSubstrings(String text) {
        char[] charArray = text.toCharArray();
        int len=charArray.length;
        Set<String> set=new HashSet<>();
        for (int i=0;i<len;++i){
            int[] pmt = getPmt(text.substring(i));
            for (int j=0;j<pmt.length;++j){
                if (pmt[j]!=0 && (j+1)%(j+1-pmt[j]) ==0 && (j+1)/(j+1-pmt[j])%2==0)
                    set.add(text.substring(i,i+j/2+1));
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        long f = System.currentTimeMillis();
        int i = solution.distinctEchoSubstrings("abcabcabc");
        long t = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(t-f);
    }
}