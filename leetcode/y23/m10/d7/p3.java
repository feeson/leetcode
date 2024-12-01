package y23.m10.d7;

import y22.m09.d27.p1.Solution;

import java.lang.reflect.Method;

/**
 一个音乐会总共有n排座位，编号从0到n - 1，每一排有m个座椅，编号为0到m - 1。你需要设计一个买票系统，针对以下情况进行座位安排：


 同一组的 k位观众坐在 同一排座位，且座位连续 。
 k位观众中 每一位都有座位坐，但他们 不一定坐在一起。


 由于观众非常挑剔，所以：


 只有当一个组里所有成员座位的排数都 小于等于maxRow，这个组才能订座位。每一组的maxRow可能 不同。
 如果有多排座位可以选择，优先选择 最小的排数。如果同一排中有多个座位可以坐，优先选择号码 最小的。


 请你实现BookMyShow类：


 BookMyShow(int n, int m)，初始化对象，n是排数，m是每一排的座位数。
 int[] gather(int k, int maxRow)返回长度为 2的数组，表示 k个成员中 第一个座位的排数和座位编号，这 k位成员必须坐在 同一排座位，且座位连续 。换言之，返回最小可能的r 和c满足第r排中[c, c + k - 1]的座位都是空的，且r <= maxRow。如果无法安排座位，返回[]。
 boolean scatter(int k, int maxRow)如果组里所有k个成员不一定要坐在一起的前提下，都能在第0 排到第maxRow排之间找到座位，那么请返回true。这种情况下，每个成员都优先找排数最小，然后是座位编号最小的座位。如果不能安排所有k个成员的座位，请返回false。




 示例 1：

 输入：
 ["BookMyShow", "gather", "gather", "scatter", "scatter"]
 [[2, 5], [4, 0], [2, 0], [5, 1], [5, 1]]
 输出：
 [null, [0, 0], [], true, false]

 解释：
 BookMyShow bms = new BookMyShow(2, 5); // 总共有 2 排，每排 5 个座位。
 bms.gather(4, 0); // 返回 [0, 0]
 // 这一组安排第 0 排 [0, 3] 的座位。
 bms.gather(2, 0); // 返回 []
 // 第 0 排只剩下 1 个座位。
 // 所以无法安排 2 个连续座位。
 bms.scatter(5, 1); // 返回 True
 // 这一组安排第 0 排第 4 个座位和第 1 排 [0, 3] 的座位。
 bms.scatter(5, 1); // 返回 False
 // 总共只剩下 2 个座位。




 提示：


 1 <= n <= 5 * 104
 1 <= m, k <= 109
 0 <= maxRow <= n - 1
 gather 和scatter总 调用次数不超过5 * 104 次。


 */
/*
https://leetcode.cn/problems/booking-concert-tickets-in-groups/
*/
class BookMyShow {
    long[] sum;
    long[] min;
    int n;
    int m;
    public BookMyShow(int n, int m) {
        int len=1<<(32-Integer.numberOfLeadingZeros(n))+2;
        sum=new long[len];
        min=new long[len];
        this.n=n;
        this.m=m;
    }
    void add(int cur,int l,int r,int idx,int val){
        if (l==r){
            sum[cur]+=val;
            min[cur]+=val;
            return;
        }
        int mid=(l+r)>>1;
        if (idx<=mid)
            add(cur*2,l,mid,idx,val);
        else
            add(cur*2+1,mid+1,r,idx,val);
        sum[cur]=sum[cur*2]+sum[cur*2+1];
        min[cur]=Math.min(min[cur*2],min[cur*2+1]);
    }

    long query(int cur,int l,int r,int L,int R){
        if (l>=L&&r<=R)
            return sum[cur];
        long s=0;
        int mid=(l+r)/2;
        if (L<=mid)
            s+=query(cur*2,l,mid,L,R);
        if (R>mid)
            s+=query(cur*2+1,mid+1,r,L,R);
        return s;
    }
    int index(int cur,int l,int r,int k,int maxRow){
        if (m-min[cur]<k)
            return -1;
        if (l==r){
            if (l>maxRow)
                return -1;
            return l;
        }
        int mid=(l+r)>>1;
        if (k<=m-min[cur*2])
            return index(cur*2,l,mid,k,maxRow);
        else
            return index(cur*2+1,mid+1,r,k,maxRow);

    }
    public int[] gather(int k, int maxRow) {
        int index=index(1,1,n,k,maxRow+1);
        if (index==-1)
            return new int[0];
        long res=query(1,1,n,index,index);
        add(1,1,n,index,k);
        return new int[]{index-1, (int) res};
    }

    public boolean scatter(int k, int maxRow) {
        long left= (long) (maxRow + 1) *m- query(1, 1, n, 1, (maxRow+1));
        if (left<k)
            return false;
        int row=index(1,1,n,1,(maxRow+1));
        while (k!=0){
            long t=m-query(1,1,n,row,row);
            t=Math.min(t,k);
            k-=t;
            add(1, 1, n, row, (int) t);
            row++;
        }
        return true;
    }

//    public static void main(String[] args) {
//        BookMyShow bookMyShow=new BookMyShow(94,270375234);
//        String[] methods=new String[]{"scatter","gather","gather","gather","scatter","gather","scatter","gather","scatter","gather","gather","scatter","scatter","scatter","gather","scatter","gather","gather","scatter","scatter","scatter","gather","gather","scatter","scatter","gather","scatter","gather","scatter","scatter","gather","gather","gather","gather","scatter","gather","gather","scatter","scatter","gather","gather","gather","gather","gather","gather","gather","gather","scatter","scatter","scatter","gather","gather","gather","scatter","gather","gather","gather","gather","scatter","gather","scatter","scatter","scatter","scatter","gather","scatter","scatter","gather","scatter","scatter","gather","gather","gather","gather","scatter","scatter","scatter","scatter","scatter","scatter","scatter","scatter","scatter","scatter","scatter","gather","gather","gather"};
//        int[][]parms=new int[][]{{94,270375234},{207095844,4},{77100725,62},{884419363,23},{600647239,92},{158051356,83},{139947052,89},{330118222,34},{891249601,82},{235182640,26},{671321662,73},{934745828,23},{984656619,67},{317540429,44},{237261016,50},{983243160,49},{861236122,16},{621805276,43},{994530399,18},{452428424,73},{575866539,90},{298798389,91},{761658355,12},{48027704,16},{971150463,89},{436762614,90},{680612643,35},{943837335,10},{324998629,79},{156747792,53},{971593275,10},{923360231,45},{542226003,47},{860320258,1},{401815756,72},{54580950,44},{81543609,19},{647463694,18},{577401649,84},{516028665,31},{767669037,41},{878139359,32},{223378679,88},{417209018,82},{797537202,58},{229372583,73},{941155543,20},{434773530,36},{25264766,9},{274827420,6},{25820525,23},{786486206,21},{114829857,52},{634911174,13},{760019125,46},{566057799,3},{381843211,86},{658978893,15},{585147969,49},{587807726,58},{975954638,46},{946814800,86},{746133129,81},{56900930,85},{942688616,61},{730183053,67},{77436121,45},{916800058,58},{271210080,26},{600203192,2},{111349316,20},{951284334,43},{730934681,20},{428838029,2},{343298113,1},{419642731,81},{305093443,90},{101915267,82},{204006922,49},{226560695,50},{247739113,62},{35591670,7},{395104585,49},{857359988,78},{930370801,24},{346999816,14},{949851770,90},{792825812,30},{154337878,47}};
//        for (int i=0;i< methods.length;++i){
//            if (methods[i].equals("scatter")){
//                bookMyShow.scatter(parms[i][0],parms[i][1]);
//            }else {
//                bookMyShow.gather(parms[i][0],parms[i][1]);
//            }
//        }
//    }
}

