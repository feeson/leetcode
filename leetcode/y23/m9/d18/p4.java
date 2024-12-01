package y23.m9.d18;
/**
 二维矩阵 grid由 0（土地）和 1（水）组成。岛是由最大的4个方向连通的 0组成的群，封闭岛是一个完全 由1包围（左、上、右、下）的岛。

 请返回 封闭岛屿 的数目。



 示例 1：



 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 输出：2
 解释：
 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。

 示例 2：



 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 输出：1


 示例 3：

 输入：grid = [[1,1,1,1,1,1,1],
 [1,0,0,0,0,0,1],
 [1,0,1,1,1,0,1],
 [1,0,1,0,1,0,1],
 [1,0,1,1,1,0,1],
 [1,0,0,0,0,0,1],
 [1,1,1,1,1,1,1]]
 输出：2




 提示：


 1 <= grid.length, grid[0].length <= 100
 0 <= grid[i][j] <=1


 */
/*
https://leetcode.cn/problems/number-of-closed-islands/?envType=daily-question&envId=2023-09-18
*/
class Solutionp4 {
    int[][]grid;
    boolean[][]visit;
    int m;
    int n;
    public int closedIsland(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        visit=new boolean[m][n];
        int res=0;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (grid[i][j]==0&&!visit[i][j]){
                    boolean dfs = dfs(i, j);
                    if (dfs)
                        res++;
                }
            }
        }
        return res;
    }
    int[][]vector=new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };
    boolean dfs(int i,int j){
        if (visit[i][j])return true;
        visit[i][j]=true;
        boolean flag=true;
        for (int k=0;k<4;++k){
            int nextI=i+vector[k][0];
            int nextJ=j+vector[k][1];
            if (!check(nextI,nextJ)){
                flag= false;
            }else if (!isWater(nextI,nextJ))
                flag&=dfs(nextI,nextJ);
        }
        return flag;
    }
    boolean check(int i,int j){
        return i>=0&&i<m&&j>=0&&j<n;
    }
    boolean isWater(int i,int j){
        return grid[i][j]==1;
    }
}
