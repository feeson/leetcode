package jiqiao.mq;

public class ST {
    int[][] dp;
    void init(int[] nums){
        int len = nums.length;
        int lg2len = (int) Math.ceil(Math.log(len)/Math.log(2));
        dp = new int[len][lg2len];
        for (int i = 0;i <len;++i){
            dp[i][0] = nums[i];
        }
        for (int j = 1; j < lg2len;j++){
            for (int i = 0;i + (1<<(j - 1)) < len;++i){
                dp[i][j] = Math.max(dp[i][j-1],dp[i + (1<<(j - 1))][j - 1]);
            }
        }
    }
    int find(int l,int r){
        int log2k = (int) (Math.log(r - l)/Math.log(2));
        return Math.max(dp[l][log2k],dp[r - (1<<log2k)][log2k]);
    }
}
