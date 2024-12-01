package y24.m9.d3.p1;

import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0;
        int r = 0;
        int cnt = 0;
        while (r < len && nums[r] < nums[l] + len){
            if (r == 0)
                cnt++;
            else if (nums[r] != nums[r - 1])
                cnt++;
            r++;
        }
        int max = cnt;
        while (r < len){
            cnt--;
            l++;
            while (nums[l] == nums[l - 1])
                l++;
            while (r < len && nums[r] < nums[l] + len){
                if (r == 0)
                    cnt++;
                else if (nums[r] != nums[r - 1])
                    cnt++;
                r++;
            }
            max = Math.max(max, cnt);
        }
        return len - max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minOperations(new int[]{8,5,9,9,8,4});
    }
}