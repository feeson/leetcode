package y23.m8.d25;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的 3 跑道道路 ，它总共包含 n + 1 个 点 ，编号为 0 到 n 。一只青蛙从 0 号点第二条跑道 出发 ，它想要跳到点 n 处。然而道路上可能有一些障碍。
 *
 * 给你一个长度为 n + 1 的数组 obstacles ，其中 obstacles[i] （取值范围从 0 到 3）表示在点 i 处的 obstacles[i] 跑道上有一个障碍。如果 obstacles[i] == 0 ，那么点 i 处没有障碍。任何一个点的三条跑道中 最多有一个 障碍。
 *
 * 比方说，如果 obstacles[2] == 1 ，那么说明在点 2 处跑道 1 有障碍。
 * 这只青蛙从点 i 跳到点 i + 1 且跑道不变的前提是点 i + 1 的同一跑道上没有障碍。为了躲避障碍，这只青蛙也可以在 同一个 点处 侧跳 到 另外一条 跑道（这两条跑道可以不相邻），但前提是跳过去的跑道该点处没有障碍。
 *
 * 比方说，这只青蛙可以从点 3 处的跑道 3 跳到点 3 处的跑道 1 。
 * 这只青蛙从点 0 处跑道 2 出发，并想到达点 n 处的 任一跑道 ，请你返回 最少侧跳次数 。
 *
 * 注意：点 0 处和点 n 处的任一跑道都不会有障碍。
 *
 * https://leetcode.cn/problems/minimum-sideway-jumps/
 */
class Solution {
    public int minSideJumps(int[] obstacles) {
        int[][] dp=new int[3][2];
        Arrays.fill(dp[0],Integer.MAX_VALUE/2);
        Arrays.fill(dp[1],Integer.MAX_VALUE/2);
        Arrays.fill(dp[2],Integer.MAX_VALUE/2);
        dp[1][0]=0;
        int t=0;
        int len= obstacles.length;
        for (int i=0;i<len-1;++i){
            int[] cost=new int[3];
            Arrays.fill(cost,Integer.MAX_VALUE);
            for (int m=0;m<3;++m){
                for (int n=0;n<3;++n){
                    // 目标位置是障碍
                    if (obstacles[i+1]==n+1)
                        continue;
                    // 起始有障碍
                    if (obstacles[i]==m+1){
                        continue;
                    }
                    if (m==n){
                        cost[n]=Math.min(cost[n],dp[m][i%2] );
                    }else {
                        // 前面无阻挡
                        if (obstacles[i+1]!=m+1){
                            cost[n]=Math.min(cost[n],dp[m][i%2]+1);
                        }else {
                            // 下面无阻挡
                            if (obstacles[i]!=n+1){
                                cost[n]=Math.min(cost[n],dp[m][i%2]+1);
                            }else {
                                cost[n]=Math.min(cost[n],dp[m][i%2]+2);
                            }
                        }
                    }

                }
            }
            for (int j=0;j<3;++j){
                dp[j][(i+1)%2]=cost[j];
            }
        }
        return Math.min(dp[0][len%2],Math.min(dp[1][len%2],dp[2][len%2]));
    }
}