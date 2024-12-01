package y23.m3.d14;

/**
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 *
 * 给你网格图的行数 n 。
 *
 * 请你返回给 grid 涂色的方案数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-ways-to-paint-n-3-grid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int numOfWays(int n) {
        int[][][]dp=new int[n][3][3];
        dp[0][0][0]=1;
        dp[0][0][1]=1;
        dp[0][0][2]=1;
        for (int i=1;i<3;++i){
            dp[0][i][0]=dp[0][i-1][1]+dp[0][i-1][2];
            dp[0][i][1]=dp[0][i-1][0]+dp[0][i-1][2];
            dp[0][i][2]=dp[0][i-1][0]+dp[0][i-1][1];
        }
        if (n==1)
            return dp[0][2][0]+dp[0][2][1]+dp[0][2][2];
        for (int i=1;i<n;++i){
            for (int j=0;j<3;++j){
                if (j==0){
                    dp[i][j][0]=dp[i-1][j][1]+dp[i-1][j][2];
                    dp[i][j][1]=dp[i-1][j][0]+dp[i-1][j][2];
                    dp[i][j][2]=dp[i-1][j][0]+dp[i-1][j][1];
                }else {
                    dp[i][j][0]=dp[i-1][j][1]+dp[i-1][j][2]+dp[i][j-1][1]+dp[i][j-1][2];
                    dp[i][j][1]=dp[i-1][j][0]+dp[i-1][j][2]+dp[i][j-1][0]+dp[i][j-1][2];
                    dp[i][j][2]=dp[i-1][j][0]+dp[i-1][j][1]+dp[i][j-1][0]+dp[i][j-1][1];
                }
            }
        }
        return dp[n-1][2][0]+dp[n-1][2][1]+dp[n-1][2][2];
    }
}