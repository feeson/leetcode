package y23.m3.d31;

/**
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 *
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-arithmetic-triplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int len=nums.length;
        int res=0;
        for (int i=0;i<len-2;++i){
            int target=nums[i]+diff;
            for (int j=i+1;j<len-1;++j){
                if (nums[j]==target){
                    target=nums[j]+diff;
                    for (int k=j+1;k<len;++k){
                        if (nums[k]==target){
                            res++;
                        }else if (nums[k]>target){
                            break;
                        }
                    }
                    break;
                }else if (nums[j]>target){
                    break;
                }
            }
        }
        return res;
    }
}