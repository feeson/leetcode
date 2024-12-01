package y24.m3.d30.taotian.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line0[0],m = line0[1],k = line0[2];
        double sum = (double) m *(double) k;
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        double[] preSum = new double[n];
        preSum[0] = nums[0];
        for (int i = 1;i < n;++i){
            preSum[i] = preSum[i - 1] + nums[i];
        }
        Arrays.sort(nums);
        int l =0,r = n - 1;
        while (l <= r){
            int mid = (l + r) / 2;
            int val = nums[mid];
            Double est = sum - (mid + 1)*nums[mid] + preSum[mid];
            if (est == 0){
                System.out.println(nums[mid]);
                return;
            }else if (est < mid){
                r = mid - 1;
            }else
                l = mid + 1;
        }
        sum -= (r + 1)*nums[r];
        long res = (long) (nums[r] + sum/(r + 1));
        System.out.println(res);
    }
}
