package y23.m10.d23;
/**
 这里有n个一样的骰子，每个骰子上都有k个面，分别标号为1到 k 。

 给定三个整数 n , k 和target，返回可能的方式(从总共kn种方式中)滚动骰子的数量，使正面朝上的数字之和等于target。

 答案可能很大，你需要对109+ 7 取模。



 示例 1：

 输入：n = 1, k = 6, target = 3
 输出：1
 解释：你扔一个有 6 个面的骰子。
 得到 3 的和只有一种方法。


 示例 2：

 输入：n = 2, k = 6, target = 7
 输出：6
 解释：你扔两个骰子，每个骰子有 6 个面。
 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。


 示例 3：

 输入：n = 30, k = 30, target = 500
 输出：222616187
 解释：返回的结果必须是对 109 + 7 取模。



 提示：


 1 <= n, k <= 30
 1 <= target <= 1000


 */
/*
https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/?envType=daily-question&envId=2023-10-24
*/
class Solution {
    int mod= (int) (1e9+7);
    public int numRollsToTarget(int n, int k, int target) {
        //dp[i][j]=dp[i][]
        int[][] dp=new int[n][target+1];
        for (int i=1;i<=Math.min(k,target);++i){
            dp[0][i]=1;
        }
        int res=0;
        for (int i=0;i<n;++i){
            for (int j=1;j<=k;++j);
        }
        return dp[n-1][target];
    }
}