package y23.m11.d26;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 给定一个m x n 二维字符网格board和一个单词（字符串）列表 words，返回所有二维网格上的单词。

 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。



 示例 1：

 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 输出：["eat","oath"]


 示例 2：

 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 输出：[]




 提示：


 m == board.length
 n == board[i].length
 1 <= m, n <= 12
 board[i][j] 是一个小写英文字母
 1 <= words.length <= 3 * 104
 1 <= words[i].length <= 10
 words[i] 由小写英文字母组成
 words 中的所有字符串互不相同


 */
/*
https://leetcode.cn/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
    class Node{
        char c;
        Node[] nxt=new Node[4];
    }
    int m,n;
    int[] nxt(int cnt){
        return new int[]{cnt-n,cnt-1,cnt+1,cnt+n};
    }
    int getCnt(int i,int j){
        return i*n+j;
    }
    Node[] nodes;
    static int func(){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        BigInteger bigInteger = new BigInteger(String.valueOf(1L));
        while (line.length()>1){
            for (int i=0;i<line.length();++i){
                if (line.charAt(i)!= '0'){
                    bigInteger = bigInteger.multiply(BigInteger.valueOf(line.charAt(i)-'0'));
                }
            }
            line = bigInteger.toString();
            bigInteger = new BigInteger(String.valueOf(1L));
        }
        return Integer.parseInt(line);
    }

    public static void main(String[] args) {
        System.out.println(func());
    }
    boolean checkValidate(int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}