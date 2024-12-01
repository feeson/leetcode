package y24.m9.d4.p1;
/*
3072. 将元素分配到两个数组中 II
给你一个下标从 1 开始、长度为 n 的整数数组 nums 。

现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。

你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：


	如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr1 。
	如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 arr2 。
	如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数量较少的数组中。
	如果仍然相等，那么将 nums[i] 追加到 arr1 。


连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 result = [1,2,3,4,5,6] 。

返回整数数组 result 。



示例 1：

输入：nums = [2,1,3,3]
输出：[2,3,1,3]
解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
因此，连接形成的数组 result 是 [2,3,1,3] 。


示例 2：

输入：nums = [5,14,3,1,2]
输出：[5,3,1,2,14]
解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
因此，连接形成的数组 result 是 [5,3,1,2,14] 。


示例 3：

输入：nums = [3,3,3,3]
输出：[3,3,3,3]
解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
因此，连接形成的数组 result 是 [3,3,3,3] 。




提示：


	3 <= n <= 105
	1 <= nums[i] <= 109


*/
/*
href: https://leetcode.cn/problems/distribute-elements-into-two-arrays-ii/?envType=daily-question&envId=2024-09-03
*/


import java.util.Arrays;

class Solution {
    int lowbit(int x){
        return x&(-x);
    }
    int bifind(int[] sorted, int val){
        int len = sorted.length;
        int l = 0, r = len - 1;
        while (l <= r){
            int mid = (l + r) >> 1;
            if (val >= sorted[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return len - l - 1;
    }
    void add(int[] sorted,int[] st, int val){
        int index = bifind(sorted, val - 1);
        add(st, index, 1);
    }

    void add(int[] arr, int index, int val){
        int len = arr.length;
        index++;
        while (index > 0 && index < len){
            arr[index - 1] += val;
            index += lowbit(index);
        }
    }
    int sum(int[] sorted, int[] st, int val){
        int index = bifind(sorted, val);
        return sum(st, index);
    }

    int sum(int[] arr, int index){
        int len = arr.length;
        index++;
        int sum = 0;
        while (index > 0 && index <= len){
            sum += arr[index - 1];
            index -= lowbit(index);
        }
        return sum;
    }
    public int[] resultArray(int[] nums) {
        int len = nums.length;
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        int[] sorted = Arrays.copyOf(nums, len);
        Arrays.sort(sorted);

        if (len <= 2)
            return nums;
        int sz1 = 0, sz2 = 0, sz = 0;
        int[] st1 = new int[len], st2 = new int[len];
        arr1[sz1++] = nums[sz++];
        add(sorted, st1, arr1[0]);
        arr2[sz2++] = nums[sz++];
        add(sorted, st2, arr2[0]);
        while (sz < len) {
            int val = nums[sz];
            int v1 = sum(sorted, st1, val);
            int v2 = sum(sorted, st2, val);
            boolean insert1 = true;
            if (v1 < v2){
                insert1 = false;
            }else if (v1 == v2 && sz2 < sz1){
                insert1 = false;
            }
            if (insert1){
                arr1[sz1++] = nums[sz++];
                add(sorted, st1, val);
            }else {
                arr2[sz2++] = nums[sz++];
                add(sorted, st2, val);
            }
        }
        sz = 0;
        while (sz < len){
            if (sz < sz1){
                nums[sz] = arr1[sz];
            }else {
                nums[sz] = arr2[sz - sz1];
            }
            sz++;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.resultArray(new int[]{2,1,3,3});
    }
}