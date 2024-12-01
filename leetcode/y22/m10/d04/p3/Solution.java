package y22.m10.d04.p3;

/**
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 *
 * 请你返回最终这些形体的总表面积。
 *
 * 注意：每个形体的底面也需要计入表面积中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int height;
    int width;
    public int surfaceArea(int[][] grid) {
        height=grid.length;
        width=grid[0].length;
        int res=0;
        for (int i=0;i<height;++i){
            for (int j=0;j<width;++j){
                res+=check(i,j,grid);
            }
        }
        return res;
    }
    int check(int i,int j,int[][] grid){
        int val=grid[i][j];
        int face=0;
        if (val!=0)
            face+=2;
        //top
        if (j==0){
            face+=val;
        }else {
            if (val>grid[i][j-1]){
                face+=val-grid[i][j-1];
            }
        }
        //bottom
        if (j+1==height){
            face+=val;
        }else {
            if (val>grid[i][j+1]){
                face+=val-grid[i][j+1];
            }
        }
        //left
        if (i==0){
            face+=val;
        }else {
            if (val>grid[i-1][j]){
                face+=val-grid[i-1][j];
            }
        }
        //right
        if (i+1==width){
            face+=val;
        }else {
            if (val>grid[i+1][j]){
                face+=val-grid[i+1][j];
            }
        }
        return face;
    }
}