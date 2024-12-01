package y23.m10.d29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 字典wordList 中从单词 beginWord和 endWord 的 转换序列 是一个按下述规格形成的序列beginWord -> s1-> s2-> ... -> sk：


 每一对相邻的单词只差一个字母。
 对于1 <= i <= k时，每个si都在wordList中。注意， beginWord不需要在wordList中。
 sk== endWord


 给你两个单词 beginWord和 endWord 和一个字典 wordList ，返回 从beginWord 到endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。


 示例 1：

 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 输出：5
 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。


 示例 2：

 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 输出：0
 解释：endWord "cog" 不在字典中，所以无法进行转换。



 提示：


 1 <= beginWord.length <= 10
 endWord.length == beginWord.length
 1 <= wordList.length <= 5000
 wordList[i].length == beginWord.length
 beginWord、endWord 和 wordList[i] 由小写英文字母组成
 beginWord != endWord
 wordList 中的所有字符串 互不相同


 */
/*
https://leetcode.cn/problems/word-ladder/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp2 {
    List<int[]> edges=new ArrayList<>();
    int[]head;
    int cnt=0;
    void add(int from,int to){
        edges.add(new int[]{from,to,head[from]});
        head[from]=edges.size()-1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> bank) {
        int flag=-1;
        for (int i=0;i<bank.size();++i){
            if (bank.get(i).equals(endWord)){
                flag=i;
                break;
            }
        }
        if (flag==-1)
            return 0;
        bank.add(beginWord);
        int len= bank.size();
        head=new int[len];
        Arrays.fill(head,-1);

        for (int i=0;i<len;++i) {
            for (int j = 0; j < len; ++j) {
                int d = distance(bank.get(i), bank.get(j));
                if (d==1)
                    add(i,j);
            }
        }
        int[]minDist=new int[len];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        boolean[]visited=new boolean[len];
        visited[len-1]=true;
        for (int edge=head[len-1];edge!=-1;edge=edges.get(edge)[2]){
            int to=edges.get(edge)[1];
            minDist[to]=1;
        }
        //dijkstra
        for (int i=0;i<len-1;++i){
            int index=-1;
            int min=Integer.MAX_VALUE;
            for (int j=0;j<len;++j){
                if (!visited[j]&&minDist[j]<min){
                    index=j;
                    min=minDist[j];
                }
            }
            if (index==-1)
                break;
            int curCost=minDist[index];
            visited[index]=true;
            for (int edge=head[index];edge!=-1;edge=edges.get(edge)[2]){
                int to=edges.get(edge)[1];
                minDist[to]=Math.min(minDist[to],curCost+1);
            }
        }
        return minDist[flag]==Integer.MAX_VALUE?0:minDist[flag]+1;
    }
    int distance(String gen1,String gen2){
        int length=0;
        for (int i=0;i<gen1.length();++i){
            if (gen1.charAt(i)!=gen2.charAt(i))
                length++;
        }
        return length;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        String str1="red";
//        String str2="tax";
//        String[] strs=new String[]{"ted","tex","red","tax","tad","den","rex","pee"};
//        List<String> list=new ArrayList<>();
//        list.addAll(List.of(strs));
//        solution.ladderLength(str1,str2,list);
//    }
}