package y23.m10.d6;
/**
 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。




 示例 1：

 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。


 示例 2：

 输入：board = [["X"]]
 输出：[["X"]]




 提示：


 m == board.length
 n == board[i].length
 1 <= m, n <= 200
 board[i][j] 为 'X' 或 'O'




 */
/*
https://leetcode.cn/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp8 {
    boolean[][] marked;
    char[][]board;
    int m,n;
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        marked=new boolean[m][n];
        this.board=board;
        for (int i=0;i<n;++i){
            if (board[0][i]=='O')
                dfs(0,i);
            if (board[m-1][i]=='O')
                dfs(m-1,i);
        }
        for (int i=0;i<m;++i){
            if (board[i][0]=='O')
                dfs(i,0);
            if (board[i][n-1]=='O')
                dfs(i,n-1);
        }
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (board[i][j]=='O'&&!marked[i][j])
                    board[i][j]='X';
            }
        }
    }
    boolean check(int i,int j){
        return i>=0&&j>=0&&i<m&&j<n&&board[i][j]=='O';
    }
    int[][]vec=new int[][]{
            {0,1},{1,0},{0,-1},{-1,0}
    };
    void dfs(int i,int j){
        if (marked[i][j])
            return;
        marked[i][j]=true;
        for (int t=0;t<4;++t){
            int nx=i+vec[t][0];
            int ny=j+vec[t][1];
            if (check(nx,ny)&&!marked[nx][ny])
                dfs(nx,ny);
        }
    }
}