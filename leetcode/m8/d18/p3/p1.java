package y24.m8.d18.p3;

public class p1 {
    int[] pa;
    int find(int i){
        if (pa[i] == i)
            return i;
        return pa[i] = find(pa[i]);
    }

    void union(int i,int j){
        int findi = find(i);
        int findj = find(j);
        if (findi == findj)
            return;
        pa[findj] = findi;
    }
}
