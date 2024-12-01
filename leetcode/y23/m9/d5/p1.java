package y23.m9.d5;

import java.util.Arrays;

/**
 给你两个只包含 1 到 9 之间数字的数组nums1 和nums2，每个数组中的元素 互不相同，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。


 示例 1：

 输入：nums1 = [4,1,3], nums2 = [5,7]
 输出：15
 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。


 示例 2：

 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 输出：3
 解释：数字 3 的数位 3 在两个数组中都出现了。




 提示：


 1 <= nums1.length, nums2.length <= 9
 1 <= nums1[i], nums2[i] <= 9
 每个数组中，元素 互不相同。


 */
/*
https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/?envType=daily-question&envId=2023-09-05
*/
class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int minx=Integer.MAX_VALUE;
        int miny=minx;
        int res=miny;
        for (int i=0;i<nums1.length;++i){
            minx=Integer.min(minx,nums1[i]);
            for (int j=0;j<nums2.length;++j){
                if (nums1[i]==nums2[j]){
                    res=Integer.min(res,nums1[i]);
                }
                miny=Integer.min(miny,nums2[j]);
            }
        }
        if (res!=Integer.MAX_VALUE)
            return res;
        return 10*Integer.min(minx,miny)+Integer.max(minx,miny);

    }
}