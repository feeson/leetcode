package y23.m4.d6;

/**
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 *
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-to-base-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String baseNeg2(int n) {
        String ans="";
        int suffix=-1;
        int divide=-1;
        do {
            divide=n/-2;
            suffix=n%-2;
            n=divide;
            if (suffix<0) {
                suffix = 1;
                n += 1;
            }
            ans+=suffix;
        }while (n!=0);
        return String.valueOf(new StringBuilder(ans).reverse());
    }
}