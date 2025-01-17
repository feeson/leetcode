package y23.m3.d14;

/**
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 *
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 *
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//class Solution {
//    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
//        int row=rowSum.length;
//        int col=colSum.length;
//        long sum[]=new long[row];
//        int[][]matrix=new int[row][col];
//        for (int i=0;i<col;++i){
//            matrix[0][i]=colSum[i];
//            sum[0]+=colSum[i];
//        }
//        for (int i=0;i<row;++i){
//            if (sum[i]>rowSum[i]){
//               long delta=sum[i]-rowSum[i];
//               for (int j=col-1;j>=0;--j){
//                   if (delta>0){
//                       long tmp=matrix[i][j];
//                       if (delta-tmp<0){
//                           matrix[i][j]= (int) (tmp-delta);
//                           matrix[i+1][j]= (int) delta;
//                           delta=0;
//                       }else {
//                           matrix[i][j]=0;
//                           matrix[i+1][j]= (int) tmp;
//                           delta-=tmp;
//                       }
//                   }else {
//                       break;
//                   }
//               }
//               if (i!=row-1)
//                   sum[i+1]=sum[i]-rowSum[i];
//            }
//        }
//        return matrix;
//    }
//}