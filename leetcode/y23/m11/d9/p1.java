package y23.m11.d9;

import java.util.*;

/**
 给你一个下标从 0开始大小为 m x n的二维整数数组grid，它表示一个网格图。每个格子为下面 3 个值之一：


 0 表示草地。
 1 表示着火的格子。
 2表示一座墙，你跟火都不能通过这个格子。


 一开始你在最左上角的格子(0, 0)，你想要到达最右下角的安全屋格子(m - 1, n - 1)。每一分钟，你可以移动到相邻的草地格子。每次你移动 之后，着火的格子会扩散到所有不是墙的 相邻格子。

 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1。如果不管你在初始位置停留多久，你 总是能到达安全屋，请你返回109。

 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。

 如果两个格子有共同边，那么它们为 相邻格子。



 示例 1：



 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
 输出：3
 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 你仍然可以安全到达安全屋。
 停留超过 3 分钟会让你无法安全到达安全屋。

 示例 2：



 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 输出：-1
 解释：上图展示了你马上开始朝安全屋移动的情形。
 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 所以返回 -1 。


 示例 3：



 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 输出：1000000000
 解释：上图展示了初始网格图。
 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 所以返回 109 。




 提示：


 m == grid.length
 n == grid[i].length
 2 <= m, n <= 300
 4 <= m * n <= 2 * 104
 grid[i][j]是0，1或者2。
 grid[0][0] == grid[m - 1][n - 1] == 0


 */
/*
https://leetcode.cn/problems/escape-the-spreading-fire/?envType=daily-question&envId=2023-11-09
*/
class Solutionp1 {
    // pos = m * 1e5 + n
    int[][] grid;
    int m,n;
    boolean dfs(int pos, int step, int[][]manGrid, boolean[]walked, int[] s,
                Deque<Integer> deque, Set<Integer> set){
        int[] mn = getMN(pos);
        if (walked[pos]&&manGrid[mn[0]][mn[1]]<step)
            return false;
        walked[pos]=true;
        manGrid[mn[0]][mn[1]]=step;
        s[step]++;
        if (mn[0]==m-1&&mn[1]==n-1)
            return true;
        int to=0;
        int fai=0;
        for (int[]diff:arr){
            int nx=diff[0]+mn[0];
            int ny=diff[1]+mn[1];

            int pos1 = getPos(nx, ny);
            if (!check(nx,ny)){
                continue;
            }
            to++;
            boolean dfs = dfs(pos1, step + 1, manGrid, walked, s,
                              deque, set);
            if (!dfs)
                fai++;

        }
        if (to==fai){
            s[step]--;
            manGrid[mn[0]][mn[1]]=-1;
            return false;
        }
        return true;
    }
    public int maximumMinutes(int[][] grid) {
        this.grid=grid;
        this.m=grid.length;
        this.n=grid[0].length;
        int step=0;

        int[]s=new int[m*n];
        Deque<Integer> deque=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();

        int[][]manGrid = new int[m][n];
        boolean[]walked=new boolean[m*n];

        dfs(0,0,manGrid,walked,s,deque,set);
        if (manGrid[m-1][n-1]==0)
            return -1;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (grid[i][j]==1){
                    int pos = getPos(i, j);
                    set.add(pos);
                    deque.addLast(pos);
                }
            }
        }
        for (int i=0;i<manGrid.length;++i){
            for (int j=0;j<manGrid[0].length;++j){
                if (grid[i][j]==0){
                    if (manGrid[i][j]<=0)
                        System.out.print("_"+"\t ");
                    else
                        System.out.print(manGrid[i][j]+"\t ");
                }
                else if (grid[i][j]==1)
                    System.out.print("O"+"\t ");
                else
                    System.out.print("M"+"\t ");
            }
            System.out.println();
        }
        int maxStep = -1;
        while (!deque.isEmpty()){
            int size=deque.size();
            for (int i=0;i<size;++i){
                Integer pos = deque.pollFirst();
                int[] index = getMN(pos);
                for (int j=0;j<4;++j){
                    int nextm=index[0]+arr[j][0];
                    int nextn=index[1]+arr[j][1];
                    if (!check(nextm,nextn))
                        continue;
                    int nextPos = getPos(nextm, nextn);
                    if (set.contains(nextPos))
                        continue;
                    if (manGrid[nextm][nextn]>=0){
                        int res=step-manGrid[nextm][nextn];
                        if (nextm==m-1&&nextn==n-1)
                            res++;
                        if (res<0&&s[step]==0) {
                            return -1;
                        }
                        maxStep=Math.max(maxStep,res);
                    }
                    set.add(nextPos);
                    deque.addLast(nextPos);
                }
            }
            step++;
        }
        if (maxStep==-1)
            return (int) 1e9;
        else
            return maxStep;
    }
    int getPos(int m,int n){
        return m*this.n+n;
    }
    int[] getMN(int pos){
        return new int[]{pos/this.n,pos%this.n};
    }
    int[][]arr=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    boolean check(int nextm,int nextn){
        return nextm>=0&&nextm<m&&nextn>=0&&nextn<n&&grid[nextm][nextn]==0;
    }
    boolean checkF(int nextm,int nextn){
        return nextm>=0&&nextm<m&&nextn>=0&&nextn<n&&grid[nextm][nextn]==1;
    }
//
//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]arr=new int[][]{{0,0,0,0,0,0},{0,2,2,2,2,0},{0,0,0,1,2,0},{0,2,2,2,2,0},{0,0,0,0,0,0}};
//        for (int i=0;i<arr.length;++i){
//            for (int j=0;j<arr[0].length;++j){
//                if (arr[i][j] == 0){
//                    System.out.print("_ ");
//                }else if (arr[i][j] == 2){
//                    System.out.print("M ");
//                }else {
//                    System.out.print("O ");
//                }
//            }
//            System.out.println();
//        }
//        int i = solution.maximumMinutes(arr);
//        System.out.println(i);
//    }
}