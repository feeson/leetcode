package y23.m3.d28;

/**
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 *
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-common-supersequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        boolean isContain=false;
        isContain= len1>=len2?str1.contains(str2):str2.contains(str1);
        if (isContain){
            return len1>len2?str1:str2;
        }
        isContain=len1>=len2;
        char[] tmp1=isContain?str1.toCharArray():str2.toCharArray();
        char[] tmp2=isContain?str2.toCharArray():str1.toCharArray();
        int longLen=isContain?len1:len2;
        int shortLen=isContain?len2:len1;
        int res=0;
        int index=-1;
        for (int i=0;i<longLen+shortLen-1;i++){
            int cover=0;
            int m=i-shortLen+1<0?0:i-shortLen+1;
            for (int j=(shortLen-i-1<0?0:shortLen-i-1);j<(i>=longLen?shortLen-(i+1-longLen):shortLen);++j){
                if (tmp1[m++]==tmp2[j]) {
                    cover++;
                }
            }
            if (cover>res){
                res=cover;
                index=i;
            }
        }

        String preFix="";
        String rearFix="";

        if (index<=shortLen){
            if (shortLen- index-1>=0)
                preFix=str2.substring(0,shortLen-index-1);
            index=0;
            for (int i=preFix.length();i<shortLen;++i){
                if (tmp1[index]==tmp2[i]){
                    preFix= preFix.concat(tmp2[i]+"");
                    if (index+1>=longLen){
                        if (i+1>=shortLen)
                            break;
                        else
                            tmp1[index]=tmp2[i+1];
                        index--;
                    }
                    index++;
                }else {
                    preFix= preFix.concat(tmp1[index++]+"");
                    i--;
                }
            }
            return preFix.concat(str1.substring(index));
        }else {
            rearFix=str2.substring(shortLen-(index-longLen+1));
            index=longLen-1;
            for (int i=shortLen-rearFix.length()-1;i>=0;i--){
                if (tmp1[index]==tmp2[i]){
                    rearFix= tmp1[index]+"".concat(rearFix);
                    index--;
                }else {
                    rearFix= tmp1[index--]+"".concat(rearFix);
                    i++;
                }
            }
            return str1.substring(0,index+1).concat(rearFix);
        }

    }
}