package y22.m10.d05.p2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int length=nums.length;
        int arr[]=new int[length+1];
        for (int i=0;i<length;++i){
            int val=nums[i];
            if (val>0&&val<length){
                arr[val]=val;
            }
        }
        for (int i=1;i<length;++i){
            if (arr[i]==0){
                return i;
            }
        }
        return length+1;
    }
}