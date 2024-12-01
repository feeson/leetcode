package y23.m3.d10;

import java.util.*;
import java.util.jar.JarEntry;

/**
 * 给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。
 *
 * 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。
 *
 * 子数组 定义为原数组中连续的一组元素。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/make-sum-divisible-by-p
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length, ans = n;
//        var s = new int[n + 1];
//        for (int i = 0; i < n; ++i)
//            s[i + 1] = (s[i] + nums[i]) % p;
//        int x = s[n];
//        if (x == 0) return 0; // 移除空子数组（这行可以不要）
//
//        var last = new HashMap<Integer, Integer>();
//        for (int i = 0; i <= n; ++i) {
//            last.put(s[i], i);
//            // 如果不存在，-n 可以保证 i-j >= n
//            int j = last.getOrDefault((s[i] - x + p) % p, -n);
//            ans = Math.min(ans, i - j);
//        }
        return ans < n ? ans : -1;
    }
}