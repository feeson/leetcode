package y23.m9.d14;
/**
 给你一个非负整数数组 nums 和一个整数 target 。

 向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：


 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。


 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。



 示例 1：

 输入：nums = [1,1,1,1,1], target = 3
 输出：5
 解释：一共有 5 种方法让最终目标和为 3 。
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3


 示例 2：

 输入：nums = [1], target = 1
 输出：1




 提示：


 1 <= nums.length <= 20
 0 <= nums[i] <= 1000
 0 <= sum(nums[i]) <= 1000
 -1000 <= target <= 1000


 */
/*
https://leetcode.cn/problems/target-sum/
*/

    //0:不取反 1：取反
    //dp[i][j] 在0~i中构成j的数量
    //dp[i][j]=dp[i-1][j]不变+dp[i-1][j+2*sum[i]]取反
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        int len=nums.length;
        for (int val:nums)
            sum+=val;
        int[][]dp=new int[len][2*sum+1];
        dp[0][-nums[0]+sum]+=1;
        dp[0][nums[0]+sum]+=1;
        for (int i=1;i<len;++i){
            for (int j=0;j<2*sum+1;++j){
//                dp[i][j]=dp[i-1][j];
                if (j+nums[i]>=0&&j+nums[i]<=sum*2)
                    dp[i][j]+=dp[i-1][j+nums[i]];
                if (j-nums[i]>=0&&j-nums[i]<=sum*2)
                    dp[i][j]+=dp[i-1][j-nums[i]];
            }
        }
        return dp[len-1][target+sum];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[]{0,0,0,0,0,0,0,0,1};
        System.out.println(solution.findTargetSumWays(arr,1));
    }
}