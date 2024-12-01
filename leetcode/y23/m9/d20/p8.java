package y23.m9.d20;


import java.util.ArrayList;
import java.util.List;

/**
 给定一个单词数组words 和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。

 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。

 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。

 文本的最后一行应为左对齐，且单词之间不插入额外的空格。

 注意:


 单词是指由非空格字符组成的字符序列。
 每个单词的长度大于 0，小于等于maxWidth。
 输入单词数组 words至少包含一个单词。




 示例 1:

 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 输出:
 [
 "This  is  an",
 "example of text",
 "justification. "
 ]


 示例2:

 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 输出:
 [
 "What  must  be",
 "acknowledgment ",
 "shall be    "
 ]
 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 因为最后一行应为左对齐，而不是左右两端对齐。
 第二行同样为左对齐，这是因为这行只包含一个单词。


 示例3:

 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 输出:
 [
 "Science is what we",
 "understand   well",
 "enough to explain to",
 "a computer. Art is",
 "everything else we",
 "do         "
 ]




 提示:


 1 <= words.length <= 300
 1 <= words[i].length <= 20
 words[i]由小写英文字母和符号组成
 1 <= maxWidth <= 100
 words[i].length <= maxWidth


 */
/*
https://leetcode.cn/problems/text-justification/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int len=words.length;
        for (int i=0;i<len;){
            StringBuilder line=new StringBuilder();
            line.append(words[i++]);
            List<Integer> indexs=new ArrayList<>();
            while (i<len&&line.length()+words[i].length()+1<=maxWidth){
                indexs.add(line.length());
                line.append(' ');
                line.append(words[i++]);
            }
            if (line.length()<maxWidth){
                int diff=maxWidth-line.length();
                int avg=indexs.size()==0?0:diff/indexs.size();
                int tail=avg==0?diff: diff%indexs.size();
                int offset=0;
                for (int index:indexs){
                    int val=avg;
                    if (tail!=0){
                        val+=1;
                        tail--;
                    }
//                    line.insert(offset+index, " ".repeat(val));
                    offset+=val;
                }
//                line.append(" ".repeat(tail));
            }
            res.add(line.toString());
        }
        String lastLine = res.remove(res.size() - 1);
        String[] s = lastLine.split(" ");
        StringBuilder sb=new StringBuilder();
        sb.append(s[0]);
        for (int i=1;i<s.length;++i){
            if (s[i].length()==0)
                continue;
            sb.append(" ").append(s[i]);
        }
        if (sb.length()<maxWidth)
//            sb.append(" ".repeat(maxWidth-sb.length()));
        res.add(sb.toString());
        return res;
    }
}