package y23.m8.d29;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 你有 n个工作和 m 个工人。给定三个数组：difficulty,profit和worker，其中:


 difficulty[i]表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。


 每个工人最多 只能安排 一个 工作，但是一个工作可以 完成多次 。


 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。


 返回 在把工人分配到工作岗位后，我们所能获得的最大利润。



 示例 1：

 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 输出: 100
 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。

 示例 2:

 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 输出: 0



 提示:


 n == difficulty.length
 n == profit.length
 m == worker.length
 1 <= n, m <= 104
 1 <= difficulty[i], profit[i], worker[i] <= 105


 https://leetcode.cn/problems/most-profit-assigning-work/
 */
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i=0;i<n;++i){
            if (map.containsKey(difficulty[i]))
                map.replace(difficulty[i],Math.max(profit[i],map.get(difficulty[i])));
            else
                map.put(difficulty[i],profit[i]);
        }
        Set<Integer> keySet = map.keySet();
        int maxProfit=0;
        for (int key:keySet){
            maxProfit=Math.max(maxProfit,map.get(key));
            map.replace(key,maxProfit);
        }
        int ret=0;
        for (int val:worker){
            Map.Entry<Integer, Integer> entry = map.floorEntry(val);
            if (entry!=null)
                ret+=entry.getValue();
        }
        return ret;
    }
}
