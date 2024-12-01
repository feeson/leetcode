package y23.m10.d6;
/**
 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。



 示例 1：

 输入：grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 输出：1


 示例 2：

 输入：grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 输出：3




 提示：


 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] 的值为 '0' 或 '1'


 */
/*
https://leetcode.cn/problems/number-of-islands/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp7 {
    char[][]grid;
    boolean[][]visit;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];
        int res=0;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (grid[i][j]=='1'&&!visit[i][j]){
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }
    int[][]vector=new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };
    void dfs(int i,int j){
        if (visit[i][j])
            return;
        visit[i][j]=true;
        for (int k=0;k<4;++k){
            int nextI=i+vector[k][0];
            int nextJ=j+vector[k][1];
            if (check(nextI,nextJ)&&!isWater(nextI,nextJ))
                dfs(nextI,nextJ);
        }
    }
    boolean check(int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
    boolean isWater(int i,int j){
        return grid[i][j]=='0';
    }
}