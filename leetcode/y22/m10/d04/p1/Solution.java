package y22.m10.d04.p1;

import java.util.Stack;

class Solution {
    public int minAddToMakeValid(String s) {
        char[] chars=s.toCharArray();
        int left=0;
        int res=0;
        for (int i=0;i<s.length();++i){
            if (chars[i]=='('){
                left++;
            }else {
                if (left==0){
                    res++;
                }else {
                    left--;
                }
            }
        }
        return left+res;
    }
}