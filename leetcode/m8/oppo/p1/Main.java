package y24.m8.oppo.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line0 = reader.readLine();
        String line1 = reader.readLine();
        String[] nums1 = line0.split(" ");
        int len = Integer.parseInt(nums1[0]);
        int t = Integer.parseInt(nums1[1]);
        String[] nums2 = line1.split(" ");
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Long.parseLong(nums2[i]);
        }
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            long val = sum - 2 * arr[i];
            if (val >= 0 && val <= t)
                res++;
        }
        System.out.println(res);
    }
}
