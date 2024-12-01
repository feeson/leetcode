package y23.m9.d17;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。

 游戏地图用大小为m x n的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。

 现在你将作为玩家参与游戏，按规则将箱子'B'移动到目标位置'T' ：


 玩家用字符'S'表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 地板用字符'.'表示，意味着可以自由行走。
 墙用字符'#'表示，意味着障碍物，不能通行。
 箱子仅有一个，用字符'B'表示。相应地，网格上有一个目标位置'T'。
 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 玩家无法越过箱子。


 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回-1。



 示例 1：



 输入：grid = [["#","#","#","#","#","#"],
 ["#","T","#","#","#","#"],
 ["#",".",".","B",".","#"],
 ["#",".","#","#",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 输出：3
 解释：我们只需要返回推箱子的次数。

 示例 2：

 输入：grid = [["#","#","#","#","#","#"],
 ["#","T","#","#","#","#"],
 ["#",".",".","B",".","#"],
 ["#","#","#","#",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 输出：-1


 示例 3：

 输入：grid = [["#","#","#","#","#","#"],
 ["#","T",".",".","#","#"],
 ["#",".","#","B",".","#"],
 ["#",".",".",".",".","#"],
 ["#",".",".",".","S","#"],
 ["#","#","#","#","#","#"]]
 输出：5
 解释：向下、向左、向左、向上再向上。




 提示：


 m == grid.length
 n == grid[i].length
 1 <= m, n <= 20
 grid 仅包含字符'.', '#', 'S' , 'T', 以及'B'。
 grid中'S', 'B'和'T'各只能出现一个。


 */
/*
https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/?envType=daily-question&envId=Invalid+Date
*/
class Solutionp2 {
    char[][]grid;
    int m;
    int n;
    boolean[][]visited;
    public int minPushBox(char[][] grid) {
        this.grid=grid;
        n=grid.length;
        m=grid[0].length;

        visited=new boolean[m*n][m*n];
        //visited[i][j] 人物转换坐标i 箱子转化坐标j

        int si=0,sj=0,ct=0,bi=0,bj=0;
        for (int i=0;i<n;++i){
            for (int j=0;j<m;++j){
                if (grid[i][j]=='S'){
                    si=i;
                    sj=j;
                }else if (grid[i][j]=='T'){
                    ct=toCrodnt(i,j);
                }else if (grid[i][j]=='B'){
                    bi=i;
                    bj=j;
                }
            }
        }

        Deque<int[]> deque=new ArrayDeque<>();
        visited[toCrodnt(si,sj)][toCrodnt(bi,bj)]=true;
        deque.offer(new int[]{toCrodnt(si,sj),toCrodnt(bi,bj),0});
        int[][]vector=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while (!deque.isEmpty()){
            int[] poll = deque.poll();
            int cp=poll[0];
            int cb=poll[1];
            int step=poll[2];
            if (cb==ct){
                return step;
            }
            int pi=cp/m;
            int pj=cp%m;
            for (int i=0;i<4;++i){
                int nextpi=pi+vector[i][0];
                int nextpj=pj+vector[i][1];
                int cnextp=toCrodnt(nextpi,nextpj);
                if (!check(nextpi,nextpj))
                    continue;
                if (toCrodnt(nextpi,nextpj)==cb){
                    int nextbi=cb/m+vector[i][0];
                    int nextbj=cb%m+vector[i][1];
                    int cnextb=toCrodnt(nextbi,nextbj);
                    if (!check(nextbi,nextbj)||visited[cnextp][cnextb])
                        continue;
                    visited[cnextp][cnextb]=true;
                    deque.offer(new int[]{cnextp,cnextb,step+1});
                }else if (!visited[cnextp][cb]){
                    visited[cnextp][cb]=true;
                    deque.offerFirst(new int[]{cnextp,cb,step});
                }
            }
        }


        return -1;
    }
    int toCrodnt(int i,int j){
        return i*m+j;
    }
    boolean check(int i,int j){
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != '#';
    }
}
