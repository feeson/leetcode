package y23.m10.d4;
/**
 给你一个整数数组prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



 示例 1：

 输入：k = 2, prices = [2,4,1]
 输出：2
 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

 示例 2：

 输入：k = 2, prices = [3,2,6,5,0,3]
 输出：7
 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。



 提示：


 1 <= k <= 100
 1 <= prices.length <= 1000
 0 <= prices[i] <= 1000


 */
/*
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/?envType=daily-question&envId=2023-10-04
*/
class Solutionp1 {
    public int maxProfit(int k, int[] prices) {
        int len=prices.length;
        int[][][] dp=new int[len+1][2][k+1];
        for (int i=0;i<=k;++i)
            dp[0][1][i]=Integer.MIN_VALUE;
        for (int i=1;i<=k;++i){
            for (int j=0;j<len;++j){
                dp[j+1][0][i]=Math.max(dp[j][0][i],dp[j][1][i-1]+prices[j]);
                dp[j+1][1][i-1]=Math.max(dp[j][1][i-1],dp[j][0][i-1]-prices[j]);
            }
        }
        return dp[len][0][k];
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr=new int[]{3,2,6,5,0,3};
//        int i = solution.maxProfit(2, arr);
//        System.out.print(i);
//    }
}