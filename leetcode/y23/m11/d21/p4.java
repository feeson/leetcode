package y23.m11.d21;

import java.util.IllegalFormatCodePointException;

class Solutionp4 {
    public int maximumXorProduct(long a, long b, int n) {
        long mod = (long) (1e9+7);
        int h1 = 64 - Long.numberOfLeadingZeros(a);
        int h2 = 64 -Long.numberOfLeadingZeros(b);
        long c1=0,c2 =0;
        if (h1 > n){
            long t=0;
            for (int i=0;i<n;++i)
                if (((1L<<i)&a)!=0)
                    t+=(1L<<i);
            c1 = a^t;
        }
        if (h2 > n){
            long t=0;
            for (int i=0;i<n;++i)
                if (((1L<<i)&b)!=0)
                    t+=(1L<<i);
            c2 = b^t;
        }
        for (int i=n-1;i>=0;i--){
            if ((a&(1L<<i)) == (b&(1L<<i))){
                c1 += (1L <<i);
                c2 += (1L <<i);
            }else {
                if (c1>=c2)
                    c2+=(1L <<i);
                else
                    c1 +=(1L<<i);
            }
        }
        return (int) (((c1%mod)*(c2%mod))%mod);
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        int i = solution.maximumXorProduct(53449611838892L, 712958946092406L, 6);
//        System.out.println(i);
//    }
}