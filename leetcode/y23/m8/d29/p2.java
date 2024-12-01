package y23.m8.d29;

import java.util.*;

/**
 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格0 变成1 。

 返回执行此操作后，grid 中最大的岛屿面积是多少？

 岛屿 由一组上、下、左、右四个方向相连的1 形成。



 示例 1:

 输入: grid = [[1, 0], [0, 1]]
 输出: 3
 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。


 示例 2:

 输入: grid = [[1, 1], [1, 0]]
 输出: 4
 解释: 将一格0变成1，岛屿的面积扩大为 4。

 示例 3:

 输入: grid = [[1, 1], [1, 1]]
 输出: 4
 解释: 没有0可以让我们变成1，面积依然为 4。



 提示：


 n == grid.length
 n == grid[i].length
 1 <= n <= 500
 grid[i][j] 为 0 或 1


 https://leetcode.cn/problems/making-a-large-island/
 */
class Solutionp2 {
    //岛列表
    Map<Integer,Integer> iland=new HashMap<>();
    //是否遍历
    //-1:water 0: unsearched else: ilandId
    int[][]map=null;
    int[][]grid=null;
    int len=-1;
    public int largestIsland(int[][] grid) {
        this.len=grid.length;
        map=new int[len][len];
        this.grid=grid;
        for (int i=0;i<len;++i){
            for (int j=0;j<len;++j){
                if (map[i][j]==0&&grid[i][j]==1){
                    int ilandId= iland.size()+1;
                    iland.put(ilandId,0);
                    markIland(i,j,ilandId);
                }
            }
        }
        int maxSize=0;
        for (int i=0;i<len;++i){
            for (int j=0;j<len;++j){
                if (map[i][j]==-1){
                    int t=1;
                    Set<Integer> set=new HashSet<>();
                    if (i-1>=0&&grid[i-1][j]==1){
                        t+=iland.get(map[i-1][j]);
                        set.add(map[i-1][j]);
                    }
                    if (i+1<len&&grid[i+1][j]==1&&!set.contains(map[i+1][j])){
                        t+=iland.get(map[i+1][j]);
                        set.add(map[i+1][j]);
                    }
                    if (j-1>=0&&grid[i][j-1]==1&&!set.contains(map[i][j-1])){
                        t+=iland.get(map[i][j-1]);
                        set.add(map[i][j-1]);
                    }
                    if (j+1<len&&grid[i][j+1]==1&&!set.contains(map[i][j+1])){
                        t+=iland.get(map[i][j+1]);
                        set.add(map[i][j+1]);
                    }
                    maxSize=Math.max(maxSize,t);
                }
            }
        }
        if (maxSize==0){
            if (grid[0][0]==1)
                return len*len;
            else
                return 1;
        }
        return maxSize;
    }
    void markIland(int i,int j,int ilandId){
        if (i<0||j<0||i>=len|j>=len)
            return;
        if (map[i][j]==0) {
            if (grid[i][j] == 0) {
                map[i][j] = -1;
            } else {
                map[i][j] = ilandId;
                int t = iland.get(ilandId);
                iland.replace(ilandId, t + 1);
                markIland(i - 1, j, ilandId);
                markIland(i + 1, j, ilandId);
                markIland(i, j - 1, ilandId);
                markIland(i, j + 1, ilandId);
            }
        }
    }
}