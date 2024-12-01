package y23.m9.d21;
/**
 给定一个含有n个正整数的数组和一个正整数 target 。

 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



 示例 1：

 输入：target = 7, nums = [2,3,1,2,4,3]
 输出：2
 解释：子数组[4,3]是该条件下的长度最小的子数组。


 示例 2：

 输入：target = 4, nums = [1,4,4]
 输出：1


 示例 3：

 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 输出：0




 提示：


 1 <= target <= 109
 1 <= nums.length <= 105
 1 <= nums[i] <= 105




 进阶：


 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。


 */
/*
https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp6 {
    public int minSubArrayLen(int target, int[] nums) {
        int len=nums.length;
        int[]sum=new int[len+1];
        int res=len+1;
        for (int i=1;i<=len;++i){
            sum[i]=sum[i-1]+nums[i-1];
        }
        for (int i=1;i<=len;++i){
            int l=i,r=len,mid=-1;
            while (l<r){
                mid=(l+r)>>1;
                if (sum[mid]<target+sum[i-1])l=mid+1;
                else r=mid;
            }
            if (target<=sum[l]-sum[i-1])
                res=Math.min(res,l-i+1);
        }
        return res==len+1?0:res;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int target=4;
//        int[]arr=new int[]{1,4,4};
//        System.out.println(solution.minSubArrayLen(target,arr));
//    }
}