package y24.m3.d25.p9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int min(int a,int b){
        return Math.min(a,b);
    }
    static long min(long a,long b,long c){
        a = Math.min(a,b);
        return Math.min(a,c);
    }
    static long abs(long a){
        if (a < 0)
            return -a;
        return a;
    }
    public static void main(String[] args) throws IOException {
        //dp[i][j]
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[][]nums = new int[3][len];
        for (int i = 0; i < 3;++i){
            nums[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        long[][] dp =new long[3][len];
        //dp[i][j] 0-j选i的最小差值
        //dp[i][j] = min(nums[i][j] - nums[0][j - 1] + dp[0][j - 1],
        // ...)
        for (int j = 1;j < len;++j){
            for (int i = 0;i < 3; ++i){
                long diff1 =abs(nums[i][j] - nums[0][j - 1]) + dp[0][j-1];
                long diff2 =abs(nums[i][j] - nums[1][j - 1]) + dp[1][j-1];
                long diff3 =abs(nums[i][j] - nums[2][j - 1]) + dp[2][j-1];
                dp[i][j] = min(diff1,diff2,diff3);
            }
        }
        System.out.println(min(dp[0][len - 1],dp[1][len-1],dp[2][len-1]));
    }
}
