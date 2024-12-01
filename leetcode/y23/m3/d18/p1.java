package y23.m3.d18;

import javax.print.DocFlavor;

/**
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 *
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 *
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 *
 * 注意， x + y 表示连接字符串 x 和 y 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/split-two-strings-to-make-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        int len=a.length();
        if (isPalindrome(a,len))
            return true;
        if (isPalindrome(b,len))
            return true;
        boolean aBreak=true;
        boolean bBreak=true;
        for (int i=0;i<len/2;++i){
            if (!aBreak&&!bBreak)
                break;
            if (aBreak){
                if (a.charAt(i)!=b.charAt(len-1-i)){
                    aBreak=false;
                    if (isPalindrome(a.substring(i,len-i),len-2*i)||isPalindrome(b.substring(i,len-i),len-2*i)){
                        return true;
                    }
                }
            }
            if (bBreak){
                if (b.charAt(i)!=a.charAt(len-1-i)){
                    bBreak=false;
                    if (isPalindrome(b.substring(i,len-i),len-2*i)||isPalindrome(a.substring(i,len-i),len-2*i)){
                        return true;
                    }
                }
            }
        }
        if (bBreak||aBreak){
            return true;
        }
        return false;
    }
    boolean isPalindrome(String a,int len){
        for (int i=0;i<len/2;++i){
            if (a.charAt(i)!=a.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}