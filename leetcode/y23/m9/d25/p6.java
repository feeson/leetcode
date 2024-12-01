package y23.m9.d25;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。



 示例1：

 输入：nums = [1,2,3,1], k = 3
 输出：true

 示例 2：

 输入：nums = [1,0,1,1], k = 1
 输出：true

 示例 3：

 输入：nums = [1,2,3,1,2,3], k = 2
 输出：false





 提示：


 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 0 <= k <= 105


 */
/*
https://leetcode.cn/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp6 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int left=0;int right=0;
        int len=nums.length;
        for (;right<=Math.min(k,len-1);++right){
            if (set.contains(nums[right]))
                return true;
            else
                set.add(nums[right]);
        }
        while (right<len){
            set.remove(nums[left++]);
            if (set.contains(nums[right])) {
                return true;
            }
            else {
                set.add(nums[right++]);
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[]arr=new int[]{1,2,3,1,2,3};
//        solution.containsNearbyDuplicate(arr,2);
//    }
}