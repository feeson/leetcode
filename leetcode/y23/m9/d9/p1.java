package y23.m9.d9;

import java.util.*;

/**
 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。

 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。


 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。


 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。



 示例 1：

 输入：numCourses = 2, prerequisites = [[1,0]]
 输出：true
 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。

 示例 2：

 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 输出：false
 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。



 提示：


 1 <= numCourses <= 2000
 0 <= prerequisites.length <= 5000
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 prerequisites[i] 中的所有课程对 互不相同


 */
/*
https://leetcode.cn/problems/course-schedule/?envType=daily-question&envId=2023-09-09
*/
class Solution {
    int n,m,idx;
    int[] e,ne,he,cnt;
    void add(int i,int j){
        e[idx]=j;
        ne[idx]=he[i];
        he[i]=idx++;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        n=numCourses;
        m= prerequisites.length;
        e=new int[m];
        ne=new int[m];
        he=new int[n];
        Arrays.fill(he,-1);
        cnt=new int[n];
        //初始化
        for (int[] t:prerequisites){
            add(t[0],t[1]);
            cnt[t[1]]++;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for (int i=0;i<n;++i){
            if (cnt[i]==0)deque.addLast(i);
        }
        while (!deque.isEmpty()){
            int i=deque.pollFirst();
            for (int val=he[i];val!=-1;val=ne[val]){
                int j=e[val];
                if (--cnt[j]<=0)
                    deque.addLast(j);
            }
        }
        int res=0;
        for (int val:cnt)
            if (val==0)res++;
        return res==n;
    }
}