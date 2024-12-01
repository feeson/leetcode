package y23.m9.d24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.IntFunction;

class Solutionp4 {
    public long countPaths(int n, int[][] edges) {
        boolean[]isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        for (long i=2;i<=n;++i){
            if (isPrime[(int) i]){
                for (long j=i*i;j<=n;j+=i)
                    isPrime[(int)j]=false;
            }
        }
        long[]check=new long[n+1];
        ArrayList<Integer>[] edge=new ArrayList[n+1];
        Arrays.setAll(edge,
                      (IntFunction<List<Integer>>) value -> new ArrayList<>());
        for (int[]t:edges) {
            edge[t[0]].add(t[1]);
            edge[t[1]].add(t[0]);
        }
        long ret=0;
        for (int i=1;i<=n;++i){
            if (isPrime[i]){
                int sum=0;
                for (int to:edge[i]){
                    long val=-1;
                    if (check[to]!=0){
                        val=check[to];

                    }else {
                        ArrayList<Integer> walked=new ArrayList<>();
                        val=dfs(to,i,edge,walked,isPrime);
                        for (int t:walked){
                            check[t]=val;
                        }
                    }
                    ret+=sum*val;
                    sum+=val;
                }
                ret+=sum;
            }
        }
        return ret;
    }
    long dfs(int i,int pa,ArrayList<Integer>[] edge,ArrayList<Integer> walked,boolean[]isPrime){
        if (isPrime[i])return 0;
        walked.add(i);
        long n=0;
        for (int to:edge[i]){
            if (to==pa)continue;
            n+= dfs(to,i,edge,walked,isPrime);
        }
        return n+1;
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int[][]edges=new int[][]{{1,2},{1,3},{2,4},{2,5}};
//        long time=System.currentTimeMillis();
//        System.out.println(solution.countPaths(5,edges));
//        System.out.println(System.currentTimeMillis()-time);
//    }
}
