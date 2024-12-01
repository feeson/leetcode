package y24.m8.d18.p1;

public class st {
    int len;
    int log2len;
    int[][] dp;
    void init(int len,int[] nums){
        log2len = (int) (Math.log10(len)/Math.log10(2));
        dp = new int[len][log2len];
        for (int i =0;i < len; ++i){
            dp[i][0] = nums[i];
        }
        for (int j = 1; j <= log2len; ++j){
            for (int i = 0;i+(1<<j) <= len; ++i){
                dp[i][j] = Math.max(dp[i][j-1],dp[i +(1<<j - 1)][j - 1]);
            }
        }
    }

    int find(int i, int j){
        int val = (int) (Math.log10(j - i) / Math.log10(2));
        return Math.max(dp[i][val], dp[j - (1 << val)][val]);
    }
}
