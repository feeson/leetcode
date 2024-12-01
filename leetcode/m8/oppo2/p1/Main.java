package y24.m8.oppo2.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line0 = reader.readLine().split(" ");
        int len = Integer.parseInt(line0[0]);
        int t = Integer.parseInt(line0[1]);
        String[] line1 = reader.readLine().split(" ");
        long[] nums = new long[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            nums[i] = Long.parseLong(line1[i]);
            sum += nums[i];
        }
        int res = 0;
        for (long num : nums) {
            long val = sum - 2 * num;
            if (val >= 0 && val <= t)
                res++;
        }
        System.out.println(res);
    }
}
