package y23.m9.d20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。

 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

 P   A   H   N
 A P L S I I G
 Y   I   R

 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);



 示例 1：

 输入：s = "PAYPALISHIRING", numRows = 3
 输出："PAHNAPLSIIGYIR"

 示例 2：

 输入：s = "PAYPALISHIRING", numRows = 4
 输出："PINALSIGYAHRPI"
 解释：
 P     I    N
 A   L S  I G
 Y A   H R
 P     I


 示例 3：

 输入：s = "A", numRows = 1
 输出："A"




 提示：


 1 <= s.length <= 1000
 s 由英文字母（小写和大写）、',' 和 '.' 组成
 1 <= numRows <= 1000


 */
/*
https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp6 {
    public String convert(String s, int numRows) {
        int len=s.length();
        if (numRows==1)
            return s;
        List<Character>[] table=new List[numRows];
        int t=2*numRows-2;
        int[] mapTable=new int[t];
        for (int i=0;i<t;++i){
            if (i<numRows){
                table[i]=new ArrayList<>();
                mapTable[i]=i;
            }
            else
                mapTable[i]=t-i;
        }
        for (int i=0;i<len;++i){
            table[mapTable[i%t]].add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for (List<Character> list:table){
            for (char c:list){
                sb.append(c);
            }
        }
        return sb.toString();
    }

}