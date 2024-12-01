package y22.m10.d07.p1;

/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 子数组是数组中的一个连续数字序列。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-ascending-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
    }
    public static int maxAscendingSum(int[] nums) {
        int res=nums[0];
        int temp=nums[0];
        for (int i=1;i<nums.length;++i){
            if (nums[i]>nums[i-1]){
                temp+=nums[i];
            }else {
                if (temp>res){
                    res=temp;
                }
                temp=nums[i];
            }
        }
        if (temp>res){
            res=temp;
        }
        return res;
    }
}
