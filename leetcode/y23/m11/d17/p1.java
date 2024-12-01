package y23.m11.d17;

import java.util.Arrays;
import java.util.Comparator;

/**
 给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 queries[i] = [xi, yi] 。

 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。

 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。



 示例 1：

 输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
 输出：[6,10,7]
 解释：
 对于第 1 个查询：xi = 4且yi = 1 ，可以选择下标j = 0，此时 nums1[j] >= 4且nums2[j] >= 1 。nums1[j] + nums2[j]等于 6 ，可以证明 6 是可以获得的最大值。
 对于第 2 个查询：xi = 1且yi = 3 ，可以选择下标j = 2，此时 nums1[j] >= 1且nums2[j] >= 3 。nums1[j] + nums2[j]等于 10 ，可以证明 10 是可以获得的最大值。
 对于第 3 个查询：xi = 2且yi = 5 ，可以选择下标j = 3，此时 nums1[j] >= 2且nums2[j] >= 5 。nums1[j] + nums2[j]等于 7 ，可以证明 7 是可以获得的最大值。
 因此，我们返回[6,10,7] 。


 示例 2：

 输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
 输出：[9,9,9]
 解释：对于这个示例，我们可以选择下标j = 2，该下标可以满足每个查询的限制。


 示例 3：

 输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
 输出：[-1]
 解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不存在答案。




 提示：


 nums1.length == nums2.length
 n ==nums1.length
 1 <= n <= 105
 1 <= nums1[i], nums2[i] <= 109
 1 <= queries.length <= 105
 queries[i].length ==2
 xi== queries[i][1]
 yi == queries[i][2]
 1 <= xi, yi <= 109


 */
/*
https://leetcode.cn/problems/maximum-sum-queries/?envType=daily-question&envId=2023-11-17
*/
class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        // 二维偏序
        int len = nums1.length;
        int[][]arr=new int[len][2];
//        for (var i = 0;i < len;++i){
//            arr[i][0] = nums1[i];
//            arr[i][1] = nums2[i];
//        }
        Arrays.sort(arr,(a,b)-> b[0] - a[0]);
        int qlen = queries.length;
        Integer[] qes = new Integer[qlen];
//        for (var i = 0;i < qlen;++i){
//            qes[i] = i;
//        }
        Arrays.sort(qes, Comparator.comparingInt(a -> -queries[a][0]));
        int[][] stack = new int[len][2];//[0]: nums2下标 [1]: sum
        int top = -1;
//        var j = 0;
//        int[]res = new int[qlen];
//        for (var i=0; i <qlen;++i){
//            var q = queries[qes[i]];
//            for (;j < len && arr[j][0] >= q[0];j++){
//                while (top != -1 && stack[top][1] <= arr[j][0]+arr[j][1])
//                    top--;
//                if (top == -1 || stack[top][0] < arr[j][1])
//                    stack[++top] =new int[]{arr[j][1],arr[j][0]+arr[j][1]};
//            }
//            var index = bi_search(stack,top+1, q[1]);
//            res[qes[i]] = index == top+1?-1: stack[index][1];
//        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr1=new int[]{72,44};
        int[]arr2=new int[]{60,86};
        int[][]arr3=new int[][]{{33,86}};
        solution.maximumSumQueries(arr1,arr2,arr3);
    }
    int bi_search(int[][]arr,int r,int k){
        int l=0;
//        while (l < r){
//            var m = (l+r)>>1;
//            if (k > arr[m][0])
//                l = m+1;
//            else
//                r = m;
//        }
        return l;
    }
}
