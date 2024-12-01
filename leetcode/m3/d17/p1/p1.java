package y24.m3.d17.p1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
212. 单词搜索 II
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
href: https://leetcode.cn/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
    class Node{
        private Node(){}
        Node(Character n){
            c = n;
        }
        Character c;
        String str = null;
        List<Node> nodes = null;
        void add(Node n){
            if (nodes == null)
                nodes = new ArrayList<>();
            nodes.add(n);
        }
        int size(){
            if (nodes == null)
                return 0;
            return nodes.size();
        }
        int nodesContains(Character c){
            if (nodes == null)
                return -1;
            int len = nodes.size();
            for (int i =0;i<len;++i){
                if (nodes.get(i).c == c){
                    return i;
                }
            }
            return -1;
        }
    }
    class Dic{
        Node head = new Node(null);
        void put(String str){
            Node cur = head;
            for (char c:str.toCharArray()){
                int index = cur.nodesContains(c);
                if (index == -1){
                    cur.add(new Node(c));
                    index = index + cur.size();
                }
                cur = cur.nodes.get(index);
            }
            cur.str = str;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Dic dic = new Dic();
        for (String str:words){
            dic.put(str);
        }
        m = board.length;
        n = board[0].length;
        this.board = board;
        List<String> res = new ArrayList<>();
        for (int i=0;i< board.length;i++){
            for (int j=0;j<board[0].length;++j){
                char c = board[i][j];
                int index = dic.head.nodesContains(c);
                if (index != -1){
                    boolean[][] visit = new boolean[m][n];
                    List<String> strs = dfs(i,j,dic.head.nodes.get(index),visit);
                    if (strs != null)
                        res.addAll(strs);
                }
            }
        }
        Set<String> s = new HashSet<>(res);
        return new ArrayList<>(s);
    }
    int m,n;
    char[][] board;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    List<String> dfs(int i,int j,Node node,boolean[][] visit){
        if (board[i][j] != node.c)
            return null;
        List<String> res = new ArrayList<>();
        if (node.str != null) {
            res.add(node.str);
        }
        visit[i][j] = true;
        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];
            // 检查新位置是否在数组边界内
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visit[newI][newJ]) {
                int index = node.nodesContains(board[newI][newJ]);
                if (index != -1){
                    List<String> strs = dfs(newI,newJ,node.nodes.get(index), visit);
                    if (strs != null)
                        res.addAll(strs);
                }
            }
        }
        visit[i][j] = false;
        if (res.isEmpty())
            return null;
        else
            return res;
    }
}