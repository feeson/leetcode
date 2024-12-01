package y23.m9.d22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给你一个 m 行 n 列的矩阵matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。



 示例 1：

 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]


 示例 2：

 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]




 提示：


 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100


 */
/*
https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp3 {
    int m;
    int n;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        m=matrix.length;
        n=matrix[0].length;
        int[][]vct=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int v=0;
        int x=0,y=0;
        int step=1;
        int total=m*n;
        int nextI=-1,nextJ=-1;
        while (step<total){
            res.add(matrix[x][y]);
            matrix[x][y]=-200;
            nextI=x+vct[v%4][0];
            nextJ=y+vct[v%4][1];
            while (!check(nextI,nextJ,matrix)){
                v++;
                nextI=x+vct[v%4][0];
                nextJ=y+vct[v%4][1];
            }
            step++;
            x=nextI;
            y=nextJ;
        }
        res.add(matrix[x][y]);
        return res;
    }
    boolean check(int nextI,int nextJ,int[][]matrix){
        return nextI>=0&&nextI<m&&nextJ>=0&&nextJ<n&&matrix[nextI][nextJ]!=-200;
    }
//
//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]mat=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(solution.spiralOrder(mat));
//    }
}