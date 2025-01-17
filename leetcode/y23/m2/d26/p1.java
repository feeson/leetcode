package y23.m2.d26;

/**
 * n 对情侣坐在连续排列的 2n 个座位上，想要牵到对方的手。
 *
 * 人和座位由一个整数数组 row 表示，其中 row[i] 是坐在第 i 个座位上的人的 ID。情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2n-2, 2n-1)。
 *
 * 返回 最少交换座位的次数，以便每对情侣可以并肩坐在一起。 每次交换可选择任意两人，让他们站起来交换座位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int arr[]=new int[70];
    void union(int x,int y){
        arr[find(x)]=arr[find(y)];
    }
    int find(int x){
        if (arr[x]!=x)
            arr[x]=find(arr[x]);
        return arr[x];
    }
    public int minSwapsCouples(int[] row) {
        int len=row.length;
        int N=len/2;
        //初始化并查集
        for (int i=0;i<len;++i) {
            arr[i] = i;
        }
        //组环
        for (int i=0;i<len;i+=2){
            union(row[i]/2,row[i+1]/2);
        }
        int res=0;
        for (int i=0;i<N;++i){
            if (arr[i]==i)
                res++;
        }
        return N-res;

    }
}
