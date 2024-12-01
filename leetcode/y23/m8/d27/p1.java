package y23.m8.d27;

import java.util.*;

/**
 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。



 示例 1：

 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 输出：[[1,6],[8,10],[15,18]]
 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].


 示例2：

 输入：intervals = [[1,4],[4,5]]
 输出：[[1,5]]
 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。



 提示：


 1 <= intervals.length <= 104
 intervals[i].length == 2
 0 <= starti <= endi <= 104


 */
class Solutionp1 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int len=intervals.length;
        int[][]ret=new int[len][2];
        int resLen=0;
        for (int i=0;i<len-1;++i){
            if (intervals[i][1]>=intervals[i+1][0]){
                int t=Math.max(intervals[i][1],intervals[i+1][1]);
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=t;
            }else{
                ret[resLen][0]=intervals[i][0];
                ret[resLen][1]=intervals[i][1];
                resLen++;
            }
        }
        ret[resLen][0]=intervals[len-1][0];
        ret[resLen][1]=intervals[len-1][1];
        resLen++;
        return Arrays.copyOf(ret,resLen);
    }
}