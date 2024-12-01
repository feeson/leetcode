package y23.m3.d15;

import java.util.*;

/**
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 *
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 *
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 *
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximal-network-rank
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int len=roads.length;
        int[][]map=new int[n][n];
        int rank[]=new int[n];
        //构建邻接表、初始化秩矩阵
        for (int i=0;i<len;++i){
            int node1=roads[i][0];
            int node2=roads[i][1];
            map[node1][node2]=1;
            map[node2][node1]=1;
            rank[node1]+=1;
            rank[node2]+=1;
        }
        int maxRank=0;
        //取第一个城市
        for (int i=0;i<n-1;++i){
            //计算第一个城市的秩
            int rankOfFirst=rank[i];
            //取第二个城市
            for (int j=i+1;j<n;++j){
                int rankOfSec=rank[j];
                int res=map[i][j]==1?rankOfFirst+rankOfSec-1:rankOfFirst+rankOfSec;
                maxRank=Integer.max(res,maxRank);
            }
        }
        return maxRank;
    }
}