package y23.m11.d11;

import java.math.BigInteger;

/**
 给你一个长度为n的整数数组nums和一个整数numSlots，满足2 * numSlots >= n。总共有numSlots个篮子，编号为1到numSlots。

 你需要把所有n个整数分到这些篮子中，且每个篮子 至多有 2 个整数。一种分配方案的 与和定义为每个数与它所在篮子编号的 按位与运算结果之和。


 比方说，将数字[1, 3]放入篮子1中，[4, 6] 放入篮子2中，这个方案的与和为(1 AND 1) + (3 AND 1) + (4 AND 2) + (6 AND 2) = 1 + 1 + 0 + 2 = 4。


 请你返回将 nums中所有数放入numSlots个篮子中的最大与和。



 示例 1：

 输入：nums = [1,2,3,4,5,6], numSlots = 3
 输出：9
 解释：一个可行的方案是 [1, 4] 放入篮子 1中，[2, 6] 放入篮子 2中，[3, 5] 放入篮子 3 中。
 最大与和为 (1 AND 1) + (4 AND 1) + (2 AND 2) + (6 AND 2) + (3 AND 3) + (5 AND 3) = 1 + 0 + 2 + 2 + 3 + 1 = 9 。


 示例 2：

 输入：nums = [1,3,10,4,7,1], numSlots = 9
 输出：24
 解释：一个可行的方案是 [1, 1] 放入篮子 1 中，[3] 放入篮子 3 中，[4] 放入篮子 4 中，[7] 放入篮子 7 中，[10] 放入篮子 9中。
 最大与和为 (1 AND 1) + (1 AND 1) + (3 AND 3) + (4 AND 4) + (7 AND 7) + (10 AND 9) = 1 + 1 + 3 + 4 + 7 + 8 = 24 。
 注意，篮子 2 ，5 ，6 和 8 是空的，这是允许的。




 提示：


 n == nums.length
 1 <= numSlots <= 9
 1 <= n <= 2 * numSlots
 1 <= nums[i] <= 15


 */
/*
https://leetcode.cn/problems/maximum-and-sum-of-array/description/
*/
class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int len=nums.length;
//        var dp=new int[1<<numSlots*2];
        // dp[i] 集合组成为i的情况下，有n个1，前n个放置的最大值
        // dp[i + 2^j] = max(dp[i + 2^j],dp[i] + nums[k]&(j/2+1))
        long res=0;
//        for (int i=0;i<dp.length;++i){
//            int n = Integer.bitCount(i);
//            if (n>=len)
//                continue;
//            for (int j=0;j < numSlots*2;j++){
//                int nxt =  i + (1 <<j);
//                if (nxt>=dp.length)
//                    continue;
//                if ((i & (1 << j)) != 0)
//                    continue;
//                dp[nxt] = Math.max(dp[nxt],dp[i] + (nums[n]&(j/2+1)));
//                if (Integer.bitCount(nxt) == len)
//                    res=Math.max(res,dp[nxt]);
//            }
//        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.maximumANDSum(new int[]{1,2,3,4,5,6},3);
    }
}