package y23.m8.d27;
/**
 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。



 示例 1：

 输入：n = 3
 输出：[[1,2,3],[8,9,4],[7,6,5]]


 示例 2：

 输入：n = 1
 输出：[[1]]




 提示：


 1 <= n <= 20


 */
class Solution {
    public int[][] generateMatrix(int n) {
        int len= n*n;
        int lasti=0;
        int lastj=0;
        int vj=1;
        int vi=0;
        int[][]ret=new int[n][n];
        ret[0][0]=1;
        for (int i=2;i<=len;++i){
            int pi=lasti+vi;
            int pj=lastj+vj;
            if (pi>=n||pj>=n||pi<0||pj<0||ret[pi][pj]!=0){
                if (vi==0){
                    if (vj==1){
                        vi=1;
                    }else {
                        vi=-1;
                    }
                    vj=0;
                }else {
                    if (vi==1){
                        vj=-1;
                    }else {
                        vj=1;
                    }
                    vi=0;
                }
                pi=lasti+vi;
                pj=lastj+vj;
            }
            lasti=pi;
            lastj=pj;
            ret[pi][pj]=i;
        }
        return ret;
    }
}