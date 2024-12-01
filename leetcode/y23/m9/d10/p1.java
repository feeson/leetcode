package y23.m9.d10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修bi 。


 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。


 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。



 示例 1：

 输入：numCourses = 2, prerequisites = [[1,0]]
 输出：[0,1]
 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。


 示例 2：

 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 输出：[0,2,1,3]
 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。

 示例 3：

 输入：numCourses = 1, prerequisites = []
 输出：[0]



 提示：


 1 <= numCourses <= 2000
 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 ai != bi
 所有[ai, bi] 互不相同


 */
/*
https://leetcode.cn/problems/course-schedule-ii/?envType=daily-question&envId=2023-09-10
*/
class Solutionp1 {
    int[] e,ne,he,cnt;
    int idx;
    void add(int i,int j){
        e[idx]=j;
        ne[idx]=he[i];
        he[i]=idx++;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int N=numCourses,M= prerequisites.length;
        e=new int[M];
        ne=new int[M];
        he=new int[N];
        Arrays.fill(he,-1);
        cnt=new int[N];
        for (int[] t:prerequisites){
            cnt[t[1]]++;
            add(t[0],t[1]);
        }
        Deque<Integer> deque=new ArrayDeque<>();
        int fillIdx=N;
        int res[]=new int[N];
        for (int i=0;i<N;++i){
            if (cnt[i]==0)deque.addLast(i);
        }
        while (!deque.isEmpty()){
            int i=deque.pollFirst();
            res[--fillIdx]=i;
            for (int index=he[i];index!=-1;index=ne[index]){
                int j=e[index];
                if (--cnt[j]==0)deque.addLast(j);
            }
        }
        if (fillIdx==0)
            return res;
        else
            return new int[0];
    }
}