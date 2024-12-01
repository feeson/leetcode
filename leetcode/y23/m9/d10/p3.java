package y23.m9.d10;

import java.util.ArrayList;
import java.util.List;

/**
 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



 示例 1：

 输入：n = 3
 输出：["((()))","(()())","(())()","()(())","()()()"]


 示例 2：

 输入：n = 1
 输出：["()"]




 提示：


 1 <= n <= 8


 */
/*
https://leetcode.cn/problems/generate-parentheses/
*/
class Solutionp3 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        dfs(res,new StringBuilder(),n,0,0);
        return res;
    }
    void dfs(List<String> res,StringBuilder sb,int want,int spend,int deal){
        if(deal==want){
            res.add(sb.toString());
            return;
        }
        if (spend<want){
            StringBuilder nb=new StringBuilder(sb.toString());
            //加(
            sb.append('(');
            dfs(res,sb,want,spend+1,deal);
            //加)
            if (deal<spend){
                nb.append(')');
                dfs(res,nb,want,spend,deal+1);
            }
        }else {
            sb.append(')');
            dfs(res,sb,want,spend,deal+1);
        }
    }
}