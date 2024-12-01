package y23.m3.d17;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.IntBinaryOperator;

/**
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 *
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 *
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-subsequence-with-limited-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        TreeMap<Integer,Integer> treeMap=new TreeMap<>();
        int sum=0;
        int n=0;
        Arrays.sort(nums);
        for (int tmp: nums){
            sum+=tmp;
            n++;
            treeMap.put(sum,n);
        }
        for (int i=0;i<queries.length;++i){
            Map.Entry<Integer, Integer> entry = treeMap.floorEntry(queries[i]);
            queries[i]=entry==null?0:entry.getValue();
        }
        return queries;
    }
}
