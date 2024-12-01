package y23.m9.d16;

import java.math.BigInteger;

class Solutionp4 {
    long remainder=1000000007;
    public int fib(int n) {
        long[]dp=new long[3];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;++i){
            dp[i%3]=(dp[(i-1)%3]+(dp[(i-2)%3]))%remainder;
        }
        return (int) dp[n%3];
    }
}