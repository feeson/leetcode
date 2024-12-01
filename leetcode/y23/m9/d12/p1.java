package y23.m9.d12;

import java.util.*;

/**
 你总共需要上numCourses门课，课程编号依次为 0到numCourses-1。你会得到一个数组prerequisite ，其中prerequisites[i] = [ai, bi]表示如果你想选bi 课程，你 必须 先选ai课程。


 有的课会有直接的先修课程，比如如果想上课程 1，你必须先上课程 0，那么会以 [0,1]数对的形式给出先修课程数对。


 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。

 你也得到一个数组queries，其中queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程uj是否是课程vj的先决条件。

 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。



 示例 1：



 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 输出：[false,true]
 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。


 示例 2：

 输入：numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 输出：[false,false]
 解释：没有先修课程对，所以每门课程之间是独立的。


 示例 3：



 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 输出：[true,true]




 提示：




 2 <= numCourses <= 100
 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 prerequisites[i].length == 2
 0 <= ai, bi<= n - 1
 ai!= bi
 每一对[ai, bi]都 不同
 先修课程图中没有环。
 1 <= queries.length <= 104
 0 <= ui, vi<= n - 1
 ui!= vi


 */
/*
https://leetcode.cn/problems/course-schedule-iv/?envType=daily-question&envId=2023-09-12
*/
// floyd
//        int len=numCourses;
//        boolean[][] to =new boolean[len][len];
//        for (int[] t:prerequisites){
//            to[t[0]][t[1]]=true;
//        }
//        for (int k=0;k<len;++k){
//            for (int i=0;i<len;++i){
//                for (int j=0;j<len;++j){
//                    to[i][j] |= to[i][k]&&to[k][j];
//                }
//            }
//        }
//        List<Boolean> res=new ArrayList<>();
//        for (int[] t:queries){
//            res.add(to[t[0]][t[1]]);
//        }
//
//        return res;
class Solutionp1 {
    int[] ne,he,e,cnt;
    int idx;
    void add(int i,int j){
        ne[idx]=he[i];
        e[idx]=j;
        he[i]=idx++;
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int N=numCourses;
        int M= prerequisites.length;
        ne=new int[M];
        e=new int[M];
        he=new int[N];
        cnt=new int[N];
        boolean[][]to=new boolean[N][N];
        Arrays.fill(he,-1);
        for (int[]t:prerequisites){
            add(t[0],t[1]);
            ++cnt[t[1]];
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<N;++i){
            if (cnt[i]==0)deque.addLast(i);
        }
        while (!deque.isEmpty()){
            int i=deque.pollFirst();
            for (int index=he[i];index!=-1;index=ne[index]){
                int j=e[index];
                to[i][j]=true;
                for (int h=0;h<N;++h){
                    to[h][j] |= to[h][i];
                }
                if (--cnt[j]==0)deque.addLast(j);
            }
        }
        List<Boolean> res=new ArrayList<>();
        for (int[]t:queries){
            res.add(to[t[0]][t[1]]);
        }
        return res;
        //top sort


    }
}