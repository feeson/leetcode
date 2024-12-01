package y23.m9.d14;


/**
 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。



 示例 1：

 输入：nums = [1,5,11,5]
 输出：true
 解释：数组可以分割成 [1, 5, 5] 和 [11] 。

 示例 2：

 输入：nums = [1,2,3,5]
 输出：false
 解释：数组不能分割成两个元素和相等的子集。




 提示：


 1 <= nums.length <= 200
 1 <= nums[i] <= 100


 */
/*
https://leetcode.cn/problems/partition-equal-subset-sum/
*/
class Solutionp3 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; nums[i] <= j; j--) {
                if (dp[target]) {
                    return true;
                }
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}