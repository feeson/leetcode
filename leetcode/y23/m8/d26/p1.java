package y23.m8.d26;

import java.util.*;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * https://leetcode.cn/problems/summary-ranges/
 */
class Solutionp1 {
    public List<String> summaryRanges(int[] nums) {
        int len=nums.length;
        List<String> res=new ArrayList();
        int i=0;
        while (i<len){
            //记录初始值
            int start = i;
            while (start<len-1 && nums[start]+1==nums[start+1])
                start+=1;
            //跳出代表到头了/i是最后一个满足条件的
            StringBuffer sb=new StringBuffer();
            sb.append(nums[i]);
            if (start>i){
                sb.append("->");
                sb.append(nums[start]);
            }
            res.add(sb.toString());
            i=start+1;
        }
        return res;
    }
}