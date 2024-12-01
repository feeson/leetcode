package y22.m10.d06.p2;

import java.util.IllegalFormatCodePointException;
import java.util.Stack;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static  int M=Integer.MAX_VALUE/2-1;
    public static void main(String[] args){
        int[][] grid=new int[][]{{9,1,4,8}};
        System.out.println(minPathSum(grid));
    }
    /*
    迪杰斯特拉
    public static int minPathSum(int[][] grid) {
        int height=grid.length;
        int width=grid[0].length;
        int size=height*width;
        if (size==1){
            return grid[0][0];
        }

        int[] visited=new int[size];
        int[] shortest=new int[size];
        for (int i=0;i<size;++i){
            shortest[i]=M;
        }
        if (width!=1)
            shortest[1]=grid[0][1];
        if (height!=1)
            shortest[width]=grid[1][0];
        visited[0]=1;

        for (int i=0;i<size-1;++i){
            int index=-1;
            int temp=M;
            for (int j=0;j<size;++j){
                if ( visited[j]==0&&shortest[j]<temp){
                    temp=shortest[j];
                    index=j;
                }
            }

            visited[index]=1;

            //check right
            if (index%width+1!=width){
                if (visited[index+1]==0){
                    int change=shortest[index]+grid[index/width][index%width+1];
                    if (change<shortest[index+1]){
                        shortest[index+1]=change;
                    }
                }
            }
            //check bottom
            if (index/width+1!=height){
                if (visited[index+width]==0){
                    int change=shortest[index]+grid[index/width+1][index%width];
                    if (change<shortest[index+width]){
                        shortest[index+width]=change;
                    }
                }
            }
        }
        

        return shortest[size-1]+ grid[0][0];

    }
     */
    /**
     * dp[0][0]=grid[0][0]
     * dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+grid[i][j]
     *
     *  i=0
     *  dp[i][j]=dp[i][j-1]+grid[i][j]
     *  j=0
     *  dp[i][j]=dp[i-1][j]+grid[i][j]
     *
     */
    public static int minPathSum(int[][] grid) {
        int height=grid.length;
        int width=grid[0].length;
        for (int i=0;i<height;++i){
            for (int j=0;j<width;++j){
                int rightVal=Integer.MAX_VALUE;
                int bottomVal=Integer.MAX_VALUE;
                if (j!=0)
                    rightVal=grid[i][j-1];
                if (i!=0)
                    bottomVal=grid[i-1][j];
                if (i!=0||j!=0)
                    grid[i][j]=Integer.min(rightVal,bottomVal)+grid[i][j];
            }
        }
        return grid[height-1][width-1];
    }
}