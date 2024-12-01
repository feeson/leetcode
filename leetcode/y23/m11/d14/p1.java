package y23.m11.d14;

import java.util.Arrays;

/**
 有 n个城市，按从 0 到 n-1编号。给你一个边数组edges，其中 edges[i] = [fromi, toi, weighti]代表fromi和toi两个城市之间的双向加权边，距离阈值是一个整数distanceThreshold。

 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为distanceThreshold的城市。如果有多个这样的城市，则返回编号最大的城市。

 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。



 示例 1：



 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 输出：3
 解释：城市分布图如上。
 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 城市 0 -> [城市 1, 城市 2]
 城市 1 -> [城市 0, 城市 2, 城市 3]
 城市 2 -> [城市 0, 城市 1, 城市 3]
 城市 3 -> [城市 1, 城市 2]
 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。


 示例 2：



 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 输出：0
 解释：城市分布图如上。
 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 城市 0 -> [城市 1]
 城市 1 -> [城市 0, 城市 4]
 城市 2 -> [城市 3, 城市 4]
 城市 3 -> [城市 2, 城市 4]
 城市 4 -> [城市 1, 城市 2, 城市 3]
 城市 0 在阈值距离 2 以内只有 1 个邻居城市。




 提示：


 2 <= n <= 100
 1 <= edges.length <= n * (n - 1) / 2
 edges[i].length == 3
 0 <= fromi < toi < n
 1 <= weighti,distanceThreshold <= 10^4
 所有 (fromi, toi)都是不同的。


 */
/*
https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2023-11-14
*/
class Solution {
    int MAX = Integer.MAX_VALUE/2 - 7;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][]m = new int[n][n];
        for (int i = 0;i < n;++i){
            Arrays.fill(m[i],MAX);
        }
        for (int[]edge:edges){
            m[edge[0]][edge[1]]=edge[2];
            m[edge[1]][edge[0]]=edge[2];
        }
        for (int t=0;t<n;++t){
            for (int i = 0 ;i< n ;++i){
                for (int j = 0;j < n;++j){
                    if (m[i][t]+m[t][j] < m[i][j])
                        m[i][j] = m[i][t] + m[t][j];
                }
            }
        }
        int res = -1;
        int num = Integer.MAX_VALUE;
        for (int i=0;i < n;++i){
            int sum = 0;
            for (int j = 0;j < n ;++j){
                if (i == j)
                    continue;
                if (m[i][j] <= distanceThreshold)
                    sum++;
            }
            if (sum <= num){
                res = i;
                num = sum;
            }
        }
        return res;
    }
}