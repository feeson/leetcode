//给你一个下标从 0 开始的整数数组 nums 。 
//
// nums 一个长度为 k 的 子序列 指的是选出 k 个 下标 i0 < i1 < ... < ik-1 ，如果这个子序列满足以下条件，我们说它是 平衡的
// ： 
//
// 
// 对于范围 [1, k - 1] 内的所有 j ，nums[ij] - nums[ij-1] >= ij - ij-1 都成立。 
// 
//
// nums 长度为 1 的 子序列 是平衡的。 
//
// 请你返回一个整数，表示 nums 平衡 子序列里面的 最大元素和 。 
//
// 一个数组的 子序列 指的是从原数组中删除一些元素（也可能一个元素也不删除）后，剩余元素保持相对顺序得到的 非空 新数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,3,5,6]
//输出：14
//解释：这个例子中，选择子序列 [3,5,6] ，下标为 0 ，2 和 3 的元素被选中。
//nums[2] - nums[0] >= 2 - 0 。
//nums[3] - nums[2] >= 3 - 2 。
//所以，这是一个平衡子序列，且它的和是所有平衡子序列里最大的。
//包含下标 1 ，2 和 3 的子序列也是一个平衡的子序列。
//最大平衡子序列和为 14 。 
//
// 示例 2： 
//
// 
//输入：nums = [5,-1,-3,8]
//输出：13
//解释：这个例子中，选择子序列 [5,8] ，下标为 0 和 3 的元素被选中。
//nums[3] - nums[0] >= 3 - 0 。
//所以，这是一个平衡子序列，且它的和是所有平衡子序列里最大的。
//最大平衡子序列和为 13 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-2,-1]
//输出：-1
//解释：这个例子中，选择子序列 [-1] 。
//这是一个平衡子序列，而且它的和是 nums 所有平衡子序列里最大的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 👍 13 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class BIT {
        long[] arr;
        BIT(int n){
            arr=new long[n];
        }
        void update(int i,long val){
            while (i<arr.length){
                arr[i]=Math.max(arr[i],val);
                i += i&-i;
            }
        }
        long preMax(int i){
            long res=Long.MIN_VALUE;
            while (i>0){
                res=Math.max(res,arr[i]);
                i -= i&-i;
            }
            return res;
        }
    }
    public long maxBalancedSubsequenceSum(int[] nums) {
        int len=nums.length;
        long[]b=new long[len];
        for (int i=0;i<len;++i){
            b[i]=nums[i]-i;
        }
        HashSet<Long> set = new HashSet<>();
        for (long t:b)
            set.add(t);
        Long[] a = set.toArray(new Long[0]);

        long res=-1;
        BIT bit=new BIT(a.length+1);
        for (int i=0;i<len;++i){
            int index = Arrays.binarySearch(a, b[i]-1)+1;
            if (index==0)
                index=1;
            long f= Math.max(0,bit.preMax(index)) + nums[i];
            res=Math.max(res,f);
            bit.update(index,f);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.maxBalancedSubsequenceSum(new int[]{3,3,5,6});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
