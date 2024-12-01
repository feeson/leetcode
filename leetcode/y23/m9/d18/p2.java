package y23.m9.d18;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。

 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：


 路径途经的所有单元格的值都是 0 。
 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。


 畅通路径的长度 是该路径途经的单元格总数。



 示例 1：

 输入：grid = [[0,1],[1,0]]
 输出：2


 示例 2：

 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 输出：4


 示例 3：

 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 输出：-1




 提示：


 n == grid.length
 n == grid[i].length
 1 <= n <= 100
 grid[i][j] 为 0 或 1


 */
/*
https://leetcode.cn/problems/shortest-path-in-binary-matrix/?envType=daily-question&envId=2023-09-18
*/
class Solutionp2 {
    int m;
    int n;
    int[][]grid;
    boolean[][]visit;
    public int shortestPathBinaryMatrix(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.grid=grid;
        visit=new boolean[m][n];
        int[][]vector=new int[][]{{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Deque<int[]> deque=new ArrayDeque<>();
        if (grid[0][0]==0){
            deque.add(new int[]{0,0,0});
            visit[0][0]=true;
        }
        while (!deque.isEmpty()){
            int[] poll = deque.poll();
            int ni=poll[0];
            int nj=poll[1];
            int step=poll[2];
            if (ni==m-1&&nj==n-1)
                return step+1;
            for (int i=0;i<8;++i){
                int nextI=ni+vector[i][0];
                int nextJ=nj+vector[i][1];
                if (!check(nextI,nextJ))
                    continue;
                if (visit[nextI][nextJ])
                    continue;
                if (grid[nextI][nextJ]==0){
                    visit[nextI][nextJ]=true;
                    deque.offer(new int[]{nextI,nextJ,step+1});
                }
            }
        }
        return -1;
    }
    boolean check(int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
}
