package y22.m10.d09.p1;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()(()())"));
    }
    public static int scoreOfParentheses(String s) {
        int length=s.length();
        char[] chars=s.toCharArray();
        LinkedList<Integer> list=new LinkedList<>();
        boolean doMultiply=false;
        for (int i=0;i<length;++i){
            if (chars[i]=='('){
                list.push(-1);
                doMultiply=false;
            }else {
                if (list.peek()==-1){
                    list.pop();
                    list.push(1);
                    doMultiply=true;
                }else {
                    int second=list.get(list.size()-2);
                    if (second==-1){
                        int val=list.pop();
                        list.pop();
                        list.push(val*2);
                    }else {
                        if (doMultiply){
                            int val=list.pop();
                            while (list.peek()!=-1){
                                val+=list.pop();
                            }
                            list.pop();
                            list.push(val*2);
                        }else {
                            int val=1;
                            list.pop();
                            val+=list.pop();
                            list.push(val);
                        }
                    }
                }
            }
        }
        int res=0;
        if (list.size()!=1){
            while (!list.isEmpty()){
                res+=list.pop();
            }
        }else {
            res=list.pop();
        }
        return res;
    }
}