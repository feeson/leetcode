package y24.m3.d17.p2;

import java.util.ArrayList;
import java.util.List;

/*
17. 电话号码的字母组合
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。





示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]


示例 2：

输入：digits = ""
输出：[]


示例 3：

输入：digits = "2"
输出：["a","b","c"]




提示：


	0 <= digits.length <= 4
	digits[i] 是范围 ['2', '9'] 的一个数字。


*/
/*
href: https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solution {
    char[][] table = new char[][]{
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        int[] idx = new int[len];
        int t = 0;
        for (char c:digits.toCharArray()){
            idx[t++] = Integer.parseInt(String.valueOf(c));
        }
        List<String> list = new ArrayList<>();
        for (int num:idx){
            List<String> res = new ArrayList<>();
            char[] cs = table[num];
            if (list.isEmpty()){
                for (char c:cs)
                    res.add(String.valueOf(c));
            }else {
                for (char c:cs){
                    for (String str:list){
                        res.add(str+c);
                    }
                }
            }
            list = res;
        }
        return list;
    }
}

class Main{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.letterCombinations("23");
    }
}