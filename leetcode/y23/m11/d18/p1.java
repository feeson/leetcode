package y23.m11.d18;

import java.util.Arrays;

/**
 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与 nums[j] 的数位和相等。

 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。



 示例 1：

 输入：nums = [18,43,36,13,7]
 输出：54
 解释：满足条件的数对 (i, j) 为：
 - (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
 - (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
 所以可以获得的最大和是 54 。

 示例 2：

 输入：nums = [10,12,19,14]
 输出：-1
 解释：不存在满足条件的数对，返回 -1 。




 提示：


 1 <= nums.length <= 105
 1 <= nums[i] <= 109


 */
/*
https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/?envType=daily-question&envId=2023-11-18
*/
class Solution {
    public int maximumSum(int[] nums) {
        int[][]b=new int[82][2];
        for (int i =0;i<b.length;++i){
            b[i][0] = -1;
            b[i][1] = -1;
        }
        for (int val: nums){
//            var t = val;
//            int sum = t % 10;
//            while (t != 0){
//                t /= 10;
//                sum+=t%10;
//            }
//            if (val >= b[sum][0]){
//                b[sum][1] = b[sum][0];
//                b[sum][0] = val;
//            }else if (val >= b[sum][1]){
//                b[sum][1] = val;
//            }
        }
        int max = -1;
        for (int[] a:b){
            if (a[1] == -1)
                continue;
            max = Math.max(max,a[0]+a[1]);
        }
        return max;
    }
}