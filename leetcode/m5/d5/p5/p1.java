package y24.m5.d5.p5;

import java.util.ArrayDeque;

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] ans = new int[len];
        int[] deque = new int[len];
        int dequeSize = 0;
        for (int i = len - 1; i >= 0; i--){
            ans[i] = biFind(deque,dequeSize,heights[i]);
            while (dequeSize != 0 && deque[dequeSize - 1] <= heights[i])
                dequeSize--;
            deque[dequeSize++] = heights[i];
        }
        return ans;
    }

    int biFind(int[] deque, int dequeSize, int val){
        // deque单减
        // 寻找几个刚好比val小
        int l = 0;
        int r = dequeSize - 1;
        while (l <= r){
            int mid = (l + r)/2;
            if (deque[mid] >= val){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        int ans = dequeSize - r - 1;
        if (r >= 0)
            ans++;
        ans = Math.max(ans, 0);
        return ans;
    }
}

class Main{
    public static void main(String[] args) {
        int[] arr =new int[]{10,6,8,5,11,9};
        Solution solution = new Solution();
        solution.canSeePersonsCount(arr);
    }
}