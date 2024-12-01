package y23.m3.d29;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 *
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-sorted-vowel-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int arr[]={5,4,3,2,1};
    public int countVowelStrings(int n) {
        return dfs(0,n-1);
    }
    int dfs(int index,int n){
        if (n==0){
            return arr[index];
        }
        switch (index){
            case 0:
                return dfs(0,n-1)+dfs(1,n-1)+dfs(2,n-1)+dfs(3,n-1)+dfs(4,n-1);
            case 1:
                return dfs(1,n-1)+dfs(2,n-1)+dfs(3,n-1)+dfs(4,n-1);
            case 2:
                return dfs(2,n-1)+dfs(3,n-1)+dfs(4,n-1);
            case 3:
                return dfs(3,n-1)+dfs(4,n-1);
            default:
                return dfs(4,n-1);
        }
    }
}