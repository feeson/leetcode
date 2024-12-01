package y23.m9.d25;

import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。

 有效字符串需满足：


 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 每个右括号都有一个对应的相同类型的左括号。




 示例 1：

 输入：s = "()"
 输出：true


 示例2：

 输入：s = "()[]{}"
 输出：true


 示例3：

 输入：s = "(]"
 输出：false




 提示：


 1 <= s.length <= 104
 s 仅由括号 '()[]{}' 组成


 */
/*
https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp9 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int len=s.length();
        for (int i=0;i<len;++i){
            char c=s.charAt(i);
            if (isLeft(c))
                stack.push(c);
            else{
                if (stack.isEmpty())
                    return false;
                if (!isPair(stack.pop(),c))
                    return false;
            }
        }
        return stack.isEmpty();
    }
    boolean isLeft(char c){
        return c=='('||c=='{'||c=='[';
    }
    boolean isPair(char c1,char c2){
        switch (c1){
            case '{':return c2=='}';
            case '(':return c2==')';
            case '[':return c2==']';
        }
        return true;
    }
}