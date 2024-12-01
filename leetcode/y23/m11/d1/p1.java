package y23.m11.d1;

import java.util.*;

/**
 一个公司准备组织一场会议，邀请名单上有n位员工。公司准备了一张 圆形的桌子，可以坐下 任意数目的员工。

 员工编号为 0到 n - 1。每位员工都有一位 喜欢的员工，每位员工当且仅当他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会是他自己。

 给你一个下标从 0开始的整数数组favorite，其中favorite[i]表示第i位员工喜欢的员工。请你返回参加会议的最多员工数目。



 示例 1：



 输入：favorite = [2,2,1,2]
 输出：3
 解释：
 上图展示了公司邀请员工 0，1 和 2 参加会议以及他们在圆桌上的座位。
 没办法邀请所有员工参与会议，因为员工 2 没办法同时坐在 0，1 和 3 员工的旁边。
 注意，公司也可以邀请员工 1，2 和 3 参加会议。
 所以最多参加会议的员工数目为 3 。


 示例 2：

 输入：favorite = [1,2,0]
 输出：3
 解释：
 每个员工都至少是另一个员工喜欢的员工。所以公司邀请他们所有人参加会议的前提是所有人都参加了会议。
 座位安排同图 1 所示：
 - 员工 0 坐在员工 2 和 1 之间。
 - 员工 1 坐在员工 0 和 2 之间。
 - 员工 2 坐在员工 1 和 0 之间。
 参与会议的最多员工数目为 3 。


 示例 3：



 输入：favorite = [3,0,1,4,1]
 输出：4
 解释：
 上图展示了公司可以邀请员工 0，1，3 和 4 参加会议以及他们在圆桌上的座位。
 员工 2 无法参加，因为他喜欢的员工 0 旁边的座位已经被占领了。
 所以公司只能不邀请员工 2 。
 参加会议的最多员工数目为 4 。




 提示：


 n == favorite.length
 2 <= n <= 105
 0 <= favorite[i] <=n - 1
 favorite[i] != i


 */
/*
https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/?envType=daily-question&envId=2023-11-01
*/
class Solution {
    int[]in;
    int[]favorite;
    Set<Integer> unWalked=new HashSet<>();
    void walk(int i){
        if (unWalked.contains(i)){
            unWalked.remove(i);
            in[i]--;
            walk(favorite[i]);
        }
    }
    int res=-1;
    int sum=0;
    int[] heads;
    int[] to;
    int[] next;
    int cnt;
    boolean[]st;
    boolean[]ins;
    void add(int i,int j){
        to[cnt]=j;
        next[cnt]=heads[i];
        heads[i]=cnt++;
    }
    boolean dfs_c(int u,Set<Integer> ring){
        st[u]=ins[u]=true;//st标记是否遍历,ins表示是否在栈中
        int j=favorite[u];
        boolean flag=false;
        if(!st[j])flag= dfs_c(j,ring);
        else if(ins[j]){//找到环
            ring.add(j);
            flag=true;
            ins[j]=false;
        }
        ins[u]=false;
        if (!ring.contains(u)&&flag){
            ring.add(u);
            return true;
        }else if (ring.contains(u)&&flag){
            return false;
        }
        return false;
    }
    int dfs(int i){
        int res=1;
        for (int e=heads[i];e!=-1;e=next[e]){
            int t=to[e];
            res=Math.max(res,1+dfs(t));
        }
        st[i]=true;
        return res;
    }
    public int maximumInvitations(int[] favorite) {
        int len=favorite.length;
        this.favorite=favorite;
        in=new int[len];
        to=new int[len];
        next=new int[len];
        heads=new int[len];
        st=new boolean[len];
        ins=new boolean[len];
        Arrays.fill(heads,-1);
        for (int i=0;i<len;++i){
            add(favorite[i],i);
        }
        for (int i=0;i<len;++i)
            unWalked.add(i);
        for (int to:favorite)
            in[to]++;
        for (int i=0;i<len;++i){
            if (in[i]==0&&!st[i]){
                Set<Integer> rings=new HashSet<>();
                dfs_c(i,rings);
                if (rings.size()>=3)
                    res=Math.max(res,rings.size());
                else if (rings.size()==2){
                    sum+=2;
                    int maxN=0;
                    Iterator<Integer> iterator = rings.iterator();
                    int n1=iterator.next();
                    int n2=iterator.next();
                    for (int e=heads[n1];e!=-1;e=next[e]){
                        int t=to[e];
                        if (t!=n2) {
                            maxN=Math.max(maxN,dfs(t));
                        }
                    }
                    sum+=maxN;
                    maxN=0;
                    for (int e=heads[n2];e!=-1;e=next[e]){
                        int t=to[e];
                        if (t!=n1)
                            maxN=Math.max(maxN,dfs(t));
                    }
                    sum+=maxN;
                }
            }
        }
        for (int i=0;i<len;++i){
            if (!st[i]){
                Set<Integer> rings=new HashSet<>();
                dfs_c(i,rings);
                if (rings.size()>=3)
                    res=Math.max(res,rings.size());
                else
                    sum+=rings.size();
            }

        }
        return Math.max(sum,res);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]arr=new int[]{7,12,17,9,0,7,14,5,3,15,6,14,10,14,10,1,1,4};
        int i = solution.maximumInvitations(arr);
        System.out.println(i);
    }
}