package y23.m10.d29;

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        long cnt = 0;
        int len = nums.length;
        long[][] dp = new long[len][3];
        //dp[i][j] 从0-i，至从i往前j个有效的长度最小操作次数
        //dp[i][0]=min(nums[i-2][0],max(0,nums[i]-k)+min(dp[i-1][0],dp[i-1][1]))
        //dp[i][1]=min(dp[i][0],dp[i-1][0])
        dp[0][0] = Math.max(0, k - nums[0]);
        dp[0][1] = dp[0][0];
        dp[0][2] = dp[0][0];
        for (int i = 1; i < len; ++i) {
            long min=Long.MAX_VALUE;
            for (int j=1;j<3;++j){
                if (i-j<0)
                    break;
                min=  Math.min(min,Math.min(dp[i-j][0], dp[i-j][1]));
            }
            if (i<=2)
                dp[i][0]=Math.max(0,k-nums[i]);
            else
                dp[i][0]=Math.max(0,k-nums[i])+min;
            dp[i][1] = Math.min(dp[i][0], dp[i - 1][0]);
            if (i >= 2)
                dp[i][2] = Math.min(dp[i][1], dp[i - 2][0]);
            else
                dp[i][2] = dp[i][1];
        }
        return Math.min(dp[len - 1][0],
                        Math.min(dp[len - 1][1], dp[len - 1][2]));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]nums=new int[(int) 1e5];
        solution.minIncrementOperations(nums, 1000000000);
        long t=33333000000000l;
        System.out.println(t);
    }

}