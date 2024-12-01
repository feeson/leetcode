package y23.m9.d17;
/**
 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。



 示例1：

 输入：nums = [2,3,2]
 输出：3
 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。


 示例 2：

 输入：nums = [1,2,3,1]
 输出：4
 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 偷窃到的最高金额 = 1 + 3 = 4 。

 示例 3：

 输入：nums = [1,2,3]
 输出：3




 提示：


 1 <= nums.length <= 100
 0 <= nums[i] <= 1000


 */
/*
https://leetcode.cn/problems/house-robber-ii/?envType=daily-question&envId=Invalid%20Date
*/
class Solutionp1 {
    public int rob(int[] nums) {
        int len=nums.length;
        if (len==1)return nums[0];
        int[][]dp=new int[len][2];
        //dp[i] 前i最大化结果
        //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i])
        int res=0;
        int left=0;
        int right=len-1;
        dp[left][0]=nums[left];
        for (int i=1;i<len/2;++i){
            left++;right--;
            dp[left][0]=dp[left-1][1]+nums[left];
            dp[left][1]=Math.max(dp[left-1][0],dp[left-1][1]);
            dp[right][0]=dp[right+1][1]+nums[right];
            dp[right][1]=Math.max(dp[right+1][0],dp[right+1][1]);
        }

        if (len%2==0){
            res=Math.max(Math.max(dp[left][0]+dp[right][1],dp[left][1]+dp[right][0]),dp[left][1]+dp[right][1]);
        }else {
            res= Math.max(nums[len/2]+dp[left][1]+dp[right][1],Math.max(dp[left][0],dp[left][1])+Math.max(dp[right][0],dp[right][1]));
        }

        dp=new int[len][2];
        left=0;
        right=len-1;
        dp[right][0]=nums[right];;
        for (int i=1;i<len/2;++i){
            left++;right--;
            dp[left][0]=dp[left-1][1]+nums[left];
            dp[left][1]=Math.max(dp[left-1][0],dp[left-1][1]);
            dp[right][0]=dp[right+1][1]+nums[right];
            dp[right][1]=Math.max(dp[right+1][0],dp[right+1][1]);
        }

        if (len%2==0){
            return Math.max(res,Math.max(Math.max(dp[left][0]+dp[right][1],dp[left][1]+dp[right][0]),dp[left][1]+dp[right][1]));
        }else {
            return Math.max(res, Math.max(nums[len/2]+dp[left][1]+dp[right][1],Math.max(dp[left][0],dp[left][1])+Math.max(dp[right][0],dp[right][1])));
        }
        
    }
}
