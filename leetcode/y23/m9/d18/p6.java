package y23.m9.d18;

import java.util.Arrays;

/**
 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。

 返回这三个数的和。

 假定每组输入只存在恰好一个解。



 示例 1：

 输入：nums = [-1,2,1,-4], target = 1
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。


 示例 2：

 输入：nums = [0,0,0], target = 1
 输出：0




 提示：


 3 <= nums.length <= 1000
 -1000 <= nums[i] <= 1000
 -104 <= target <= 104


 */
/*
https://leetcode.cn/problems/3sum-closest/?envType=daily-question&envId=2023-09-18
*/
class Solutionp6 {
    public int threeSumClosest(int[] nums, int target) {
        int sum=0;
        int diff=Integer.MAX_VALUE;
        int len=nums.length;
        Arrays.sort(nums);
        for (int i=0;i<len-2;++i){
            int left=i+1;
            int right=len-1;
            while (left<right){
                int val=nums[i]+nums[left]+nums[right];
                int d=Math.abs(target-val);
                if (d<diff){
                    sum=val;
                    diff=d;
                }
                if (val>target){
                    right--;
                }else if (val<target){
                    left++;
                }else {
                    return target;
                }
            }
        }
        return sum;
    }
}
