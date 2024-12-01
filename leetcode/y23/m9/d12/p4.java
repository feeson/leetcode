package y23.m9.d12;

import java.util.HashSet;
import java.util.Set;

/**
 给定一个二进制字符串s和一个正整数n，如果对于[1, n]范围内的每个整数，其二进制表示都是s 的 子字符串 ，就返回 true，否则返回 false。

 子字符串是字符串中连续的字符序列。



 示例 1：

 输入：s = "0110", n = 3
 输出：true


 示例 2：

 输入：s = "0110", n = 4
 输出：false




 提示：


 1 <= s.length <= 1000
 s[i]不是'0'就是'1'
 1 <= n <= 109


 */
/*
https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/?envType=daily-question&envId=2023-09-12
*/
class Solutionp4 {
    public boolean queryString(String s, int n) {
        Set<Integer> set=new HashSet<>();
        int len=s.length();
        for (int i=len-1;i>=0;i--){
            int val=0;
            for (int j=i;j>=0;j--){
                if (s.charAt(j)=='1') {
                    val+=1<<i-j;
                    if (val>n) {
                        break;
                    }
                    set.add(val);
                }
            }
        }
        return set.size()==n;
    }

}