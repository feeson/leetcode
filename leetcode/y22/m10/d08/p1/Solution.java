package y22.m10.d08.p1;

import java.time.chrono.MinguoDate;
import java.util.*;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 *
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/advantage-shuffle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        int[] nums1=new int[]{2,0,4,1,2};
        int[] nums2=new int[]{1,3,0,0,2};
        advantageCount(nums1,nums2);
    }
    //田忌赛马策略
    //建一个下标数组来存储排序后的下标值
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //存下标，用下标代表原数组进行排序
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            //代表数据大
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                //取出对应下标     填入对应值
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

}