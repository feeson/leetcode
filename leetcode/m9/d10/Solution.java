package y24.m9.d10;

import java.util.Arrays;

class Solution {
    public long countQuadruplets(int[] nums) {
        int len = nums.length;
        long[] cnt3 = new long[len];
        long cnt4 = 0;
        for (int j = 1; j < len; j++) {
            int cntj2 = 0;
            for (int index = 0; index < j; index++) {
                if (nums[index] < nums[j]){
                    int i = index;
                    cntj2++;
                }else {
                    int k = index;
                    cnt3[k] += cntj2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,3,4};
        System.out.println("solution.countQuadruplets(arr) = " + solution.countQuadruplets(arr));
    }
}