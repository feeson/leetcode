package y23.m8.d28;

import java.util.*;

/**
 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。



 示例1：

 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 输出：[[1,5],[6,9]]


 示例 2：

 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 输出：[[1,2],[3,10],[12,16]]
 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。

 示例 3：

 输入：intervals = [], newInterval = [5,7]
 输出：[[5,7]]


 示例 4：

 输入：intervals = [[1,5]], newInterval = [2,3]
 输出：[[1,5]]


 示例 5：

 输入：intervals = [[1,5]], newInterval = [2,7]
 输出：[[1,7]]




 提示：


 0 <= intervals.length <= 104
 intervals[i].length == 2
 0 <=intervals[i][0] <=intervals[i][1] <= 105
 intervals 根据 intervals[i][0] 按 升序 排列
 newInterval.length == 2
 0 <=newInterval[0] <=newInterval[1] <= 105


 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len= intervals.length;
        List<int[]>res=new ArrayList<>();
        for (int i=0;i<len;++i){
            if (intervals[i][1]<newInterval[0]){
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }else {
                int left=Math.min(intervals[i][0],newInterval[0]);
                int start=i;
                while (i+1<len&&intervals[i+1][0]<=newInterval[1]){
                    i++;
                }
                if (start==i){
                    if (intervals[i][0]>newInterval[1]){
                        res.add(new int[]{newInterval[0],newInterval[1]});
                        res.add(new int[]{intervals[i][0],intervals[i][1]});
                    }else {
                        //res.add(new int[]{});
                        res.add(new int[]{Math.min(newInterval[0],intervals[i][0]),Math.max(newInterval[1],intervals[i][1])});
                    }

                }else {
                    int right=Math.max(intervals[i][1],newInterval[1]);
                    res.add(new int[]{left,right});
                }
                for (i++;i<len;++i){
                    res.add(new int[]{intervals[i][0],intervals[i][1]});
                }
                return res.toArray(new int[0][0]);
            }
        }
        res.add(new int[]{newInterval[0],newInterval[1]});
        return res.toArray(new int[0][0]);
    }
}