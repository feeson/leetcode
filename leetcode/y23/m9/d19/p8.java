package y23.m9.d19;
/**
 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。

 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。

 请不要使用除法，且在O(n) 时间复杂度内完成此题。



 示例 1:

 输入: nums = [1,2,3,4]
 输出: [24,12,8,6]


 示例 2:

 输入: nums = [-1,1,0,-3,3]
 输出: [0,0,9,0,0]




 提示：


 2 <= nums.length <= 105
 -30 <= nums[i] <= 30
 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内




 进阶：你可以在 O(1)的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

 */
/*
https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
*/
class Solutionp8 {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int sum=1;
        int cntZero=0;
        for (int val:nums){
            if (val==0){
                cntZero++;
            }else {
                sum*=val;
            }
        }
        int[]res=new int[len];
        for (int i=0;i<len;++i){
            if (cntZero>=2)
                res[i]=0;
            else if(cntZero==1){
                if (nums[i]!=0)
                    res[i]=0;
                else
                    res[i]=sum;
            }else {
                res[i]=sum/nums[i];
            }
        }
        return res;
    }
}