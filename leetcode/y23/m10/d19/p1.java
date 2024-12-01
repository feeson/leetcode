package y23.m10.d19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 给你一个由 不同 正整数组成的数组 nums ，请你返回满足a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。



 示例 1：

 输入：nums = [2,3,4,6]
 输出：8
 解释：存在 8 个满足题意的元组：
 (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)


 示例 2：

 输入：nums = [1,2,4,5,10]
 输出：16
 解释：存在 16 个满足题意的元组：
 (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)




 提示：


 1 <= nums.length <= 1000
 1 <= nums[i] <= 104
 nums 中的所有元素 互不相同


 */
/*
https://leetcode.cn/problems/tuple-with-same-product/?envType=daily-question&envId=2023-10-19
*/
class Solution {
    public int tupleSameProduct(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<len;++i){
            for (int j=i+1;j<len;++j){
                int val = nums[i]*nums[j];
                if (map.containsKey(val))
                    map.replace(val,map.get(val)+1);
                else
                    map.put(val,1);
            }
        }
        AtomicInteger res=new AtomicInteger(0);
        map.forEach((key1, value) -> {
            int val = value;
            if (val >= 2)
                res.getAndAdd(4 * val * (val - 1));
        });
        return res.get();
    }
}