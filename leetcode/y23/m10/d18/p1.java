package y23.m10.d18;

import java.util.*;

/**
 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。

 在一步 操作 中：


 选出一个满足 0 <= i < nums.length 的下标 i ，
 将你的 分数 增加 nums[i] ，并且
 将 nums[i] 替换为 ceil(nums[i] / 3) 。


 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。

 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。



 示例 1：

 输入：nums = [10,10,10,10,10], k = 5
 输出：50      l
 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。


 示例 2：

 输入：nums = [1,10,3,3,3], k = 3
 输出：17
 解释：可以执行下述操作：
 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
 最后分数是 10 + 4 + 3 = 17 。
 10 4 3 3 1
 l  l   r


 提示：


 1 <= nums.length, k <= 105
 1 <= nums[i] <= 109


 */
/*
https://leetcode.cn/problems/maximal-score-after-applying-k-operations/?envType=daily-question&envId=Invalid%20Date
*/
class Solution {
    public long maxKelements(int[] nums, int k) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int val:nums)
            arrayList.add(val);
        arrayList.sort(Comparator.reverseOrder());
        int len=nums.length;
        int l=0,r=Math.min(len-1,k);
        while (l<k){
            int ceil = (int) Math.ceil((double) arrayList.get(l) /3);
            while (arrayList.get(r)<ceil) {
                r--;
            }
            while (r<arrayList.size()&&arrayList.get(r)>ceil) {
                r++;
            }
            if (r<k) {
                arrayList.add(r,ceil);
            }else {
                break;
            }
            l++;
        }
        long res=0;
        for (int i=0;i<k;++i)
            res+=arrayList.get(i);
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr=new int[]{238838724,196963851,539418658,120132686,273213807,57187185,68854249,619718192};
        solution.maxKelements(arr,7);
    }
}
