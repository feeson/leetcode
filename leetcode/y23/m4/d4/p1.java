package y23.m4.d4;

import java.util.*;

import static java.util.stream.Collectors.toMap;

/**
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 *
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 *
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-cost-to-merge-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int sum[];
    int memo[][][];
    int k;
    public int mergeStones(int[] stones, int k) {
        int len=stones.length;
        if ((len-1)%(k-1)>0)
            return -1;
        sum=new int[len+1];
        this.k=k;
        memo =new int[len][len][k+1];
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                Arrays.fill(memo[i][j], -1); // -1 表示还没有计算过
        for (int i=0;i<len;++i){
            sum[i+1]=sum[i]+stones[i];
        }
        return dfs(0,len-1,1);
    }
    int dfs(int l,int r,int p){
        if (memo[l][r][p] != -1)
            return memo[l][r][p];
        if (p==1)
            return (memo[l][r][p]= (l==r?0:dfs(l,r,k)+sum[r+1]-sum[l]));
        int ans=Integer.MAX_VALUE;
        for (int i=l;i<r;i+=k-1){
            ans=Math.min(ans,dfs(l,i,1)+dfs(i+1,r,p-1));
        }
        return memo[l][r][p]=ans;
    }
}