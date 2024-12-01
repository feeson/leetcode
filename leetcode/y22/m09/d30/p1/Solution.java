package y22.m09.d30.p1;

import java.util.Arrays;

/**
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 */
/*
class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] mirror=new int[matrix.length][matrix[0].length];
        for (int i=0;i< matrix.length;++i){
            for (int j=0;j<matrix[i].length;++j){
                if (matrix[i][j]==0)
                    mirror[i][j]=1;
            }
        }
        for (int i=0;i< matrix.length;++i){
            for (int j=0;j<matrix[i].length;++j){
                if (mirror[i][j]==1){
                    for (int n=0;n<matrix[i].length;++n){
                        matrix[i][n]=0;
                    }
                    for (int m=0;m<matrix.length;++m){
                        matrix[m][j]=0;
                    }
                }
            }
        }
    }
}*/
class Solution {
    public void setZeroes(int[][] matrix) {
        int col=matrix[0].length;
        int row=matrix.length;
        int excRow[]=new int[row];
        int excCol[]=new int[col];
        for (int i=0;i< row;++i){
            for (int j=0;j<col;++j){
                if (matrix[i][j]==0){
                    excRow[i]=1;
                    excCol[j]=1;
                }
            }
        }
        for (int i=0;i<row;++i){
            if (excRow[i]==1){
                for (int j=0;j<col;++j){
                    matrix[i][j]=0;
                }
            }
        }
        for (int i=0;i<col;++i){
            if (excCol[i]==1){
                for (int j=0;j<row;++j){
                    matrix[j][i]=0;
                }
            }
        }
    }
}