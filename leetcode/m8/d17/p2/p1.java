package y24.m8.d17.p2;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        int[] nums2 = Arrays.copyOf(nums, len);
        Arrays.sort(nums2);
        while (l < len){
            if (nums[l] != nums2[l])
                break;
            ++l;
        }
        if (l >= len)
            return 0;
        while (r >= 0){
            if (nums[r] != nums2[r])
                break;
            r--;
        }
        return r - l + 1;
    }
}