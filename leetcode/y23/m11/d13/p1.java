package y23.m11.d13;

import y22.m09.d27.p1.Solution;

/**
 给你一个数组 nums ，请你完成两类查询。


 其中一类查询要求 更新 数组nums下标对应的值
 另一类查询要求返回数组nums中索引left和索引right之间（包含）的nums元素的 和，其中left <= right


 实现 NumArray 类：


 NumArray(int[] nums) 用整数数组 nums 初始化对象
 void update(int index, int val) 将 nums[index] 的值 更新 为 val
 int sumRange(int left, int right) 返回数组nums中索引left和索引right之间（包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）




 示例 1：

 输入：
 ["NumArray", "sumRange", "update", "sumRange"]
 [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 输出：
 [null, 9, null, 8]

 解释：
 NumArray numArray = new NumArray([1, 3, 5]);
 numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 numArray.update(1, 2);   // nums = [1,2,5]
 numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8




 提示：


 1 <= nums.length <= 3 *104
 -100 <= nums[i] <= 100
 0 <= index < nums.length
 -100 <= val <= 100
 0 <= left <= right < nums.length
 调用 update 和 sumRange 方法次数不大于3 * 104


 */
/*
https://leetcode.cn/problems/range-sum-query-mutable/?envType=daily-question&envId=2023-11-13
*/
class NumArray {
    class BIT {
        long[] arr;
        BIT(int n){
            arr=new long[n];
        }
        void update(int i,long val){
            i+=1;
            while (i<arr.length){
                arr[i]=arr[i]+val;
                i += i&-i;
            }
        }
        long getSum(int i){
            i+=1;
            long res=0;
            while (i>0){
                res=res+arr[i];
                i -= i&-i;
            }
            return res;
        }
    }
    BIT bit;
    int[] nums;
    public NumArray(int[] nums) {
        int len = nums.length;
        this.nums = nums;
        bit=new BIT(len+1);
        for (int i=0;i< len;++i){
            bit.update(i,nums[i]);
        }
    }

    public void update(int index, int val) {
        bit.update(index,val-nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return (int) (bit.getSum(right)-bit.getSum(left-1));
    }

    public static void main(String[] args) {
        NumArray numArray=new NumArray(new int[]{1,3,5});
        numArray.sumRange(0,2);
        numArray.update(1,2);
        numArray.sumRange(0,2);
    }
}