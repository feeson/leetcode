package y23.m9.d16;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。

 图用由边组成的二维数组 edges 表示，其中edges[i] = [ui, vi, cnti] 表示原始图中节点ui 和vi 之间存在一条边，cnti 是将边 细分 后的新节点总数。注意，cnti == 0 表示边不可细分。

 要 细分 边 [ui, vi] ，需要将其替换为 (cnti + 1) 条新边，和cnti 个新节点。新节点为 x1, x2, ..., xcnti ，新边为 [ui, x1], [x1, x2], [x2, x3], ..., [xcnti-1, xcnti], [xcnti, vi] 。

 现在得到一个新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。

 给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数。



 示例 1：

 输入：edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
 输出：13
 解释：边的细分情况如上图所示。
 可以到达的节点已经用黄色标注出来。


 示例 2：

 输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
 输出：23


 示例 3：

 输入：edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
 输出：1
 解释：节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。




 提示：


 0 <= edges.length <= min(n * (n - 1) / 2, 104)
 edges[i].length == 3
 0 <= ui < vi < n
 图中 不存在平行边
 0 <= cnti <= 104
 0 <= maxMoves <= 109
 1 <= n <= 3000


 */
/*
https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/
*/
class Solutionp1 {
    int[]result;
    int[]notVisit;
    int[][]edge;
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        result=new int[n];
        Arrays.fill(result,-1);
        notVisit=new int[n];
        Arrays.fill(notVisit,Integer.MAX_VALUE);
        edge=new int[n][n];
        //初始化零阶矩阵
        for (int[]t:edges){
            edge[t[0]][t[1]]=t[2]+1;//自己也要算进去所以+1
            edge[t[1]][t[0]]=t[2]+1;
            if (t[0]==0)
                notVisit[t[1]]=t[2]+1;
        }
        //难调的djistra
        notVisit[0]=-1;
        result[0]=0;
        for (int i=1;i<n;++i){
            int from=-1;
            int fw=Integer.MAX_VALUE;
            for (int j=0;j<n;++j){
                if (notVisit[j]!=-1&&notVisit[j]<fw){
                    from=j;
                    fw=notVisit[j];
                }
            }
            if (from==-1)
                continue;
            result[from]=fw;
            notVisit[from]=-1;
            for (int j=0;j<n;++j){
                if (edge[from][j]>0 && result[j] == -1){
                    int nd=result[from]+edge[from][j];
                    if (nd < notVisit[j] || notVisit[j]==-1)
                        notVisit[j]=nd;
                }
            }

        }
        int res=0;
        //处理边
        for (int[]t:edges){
            boolean flag1=maxMoves<=result[t[0]]||result[t[0]]==-1;
            boolean flag2=maxMoves<=result[t[1]]||result[t[1]]==-1;
            if (flag1&&flag2){
                continue;
            }else if (!flag1&&!flag2){
                int remi=maxMoves-result[t[0]];
                int remj=maxMoves-result[t[1]];
                if (remi+remj>=t[2])
                    res+=t[2];
                else
                    res+=remi+remj;
            }else if (!flag1){
                int remi= maxMoves-result[t[0]];
                if (remi>=t[2])
                    res+=t[2];
                else
                    res+=remi;
            }else {
                int remi= maxMoves-result[t[1]];
                if (remi>=t[2])
                    res+=t[2];
                else
                    res+=remi;
            }
        }
        //处理点
        for (int val:result){
            if (val<=maxMoves&&val!=-1)
                res++;
        }
        return res==0?1:res;

    }

}
