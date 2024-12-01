package y23.m9.d11;

import java.util.*;

/**
 这里有 n 门不同的在线课程，按从 1 到 n编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。

 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。

 返回你最多可以修读的课程数目。



 示例 1：

 输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 输出：3
 解释：
 这里一共有 4 门课程，但是你最多可以修 3 门：
 首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
 第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
 第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
 第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。

 示例 2：

 输入：courses = [[1,2]]
 输出：1


 示例 3：

 输入：courses = [[3,2],[4,3]]
 输出：0




 提示:


 1 <= courses.length <= 104
 1 <= durationi, lastDayi <= 104


 */
/*
https://leetcode.cn/problems/course-schedule-iii/?envType=daily-question&envId=2023-09-11
*/
class Solutionp1 {
    public int scheduleCourse(int[][] courses) {
        //dp[i][j] //对于第i课 花费时间j得到的总课程
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->b-a);
        int sum=0;
        int res=0;
        for (int[] row:courses){
            if (sum+row[0]<=row[1]){
                sum+=row[0];
                queue.add(row[0]);
                res++;
            }else {
                Integer pollT = queue.poll();
                if (pollT==null)pollT=0;
                sum-=pollT;
                pollT=Math.min(pollT,row[0]);
                queue.add(pollT);
                sum+=pollT;
            }
        }
        return res;
    }

}
