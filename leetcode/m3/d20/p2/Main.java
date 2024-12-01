package y24.m3.d20.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][]dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        // dp[i][0] i不取 dp[i][1]i取的最大值
        // dp[i][0] = max(dp[i - 1][0],dp[i - 1][1])
        // dp[i][1] = max(dp[i - 1][0] + nums[i],dp[i - 1][0])
        for (int i = 1;i<len;++i){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i],dp[i - 1][0]);
        }
        System.out.println(Math.max(dp[len - 1][0],dp[len - 1][1]));
    }
}
