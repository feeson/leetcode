package y24.m3.d18.p7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream((reader.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int res = 0;
        for (int i =0;i<n;++i){
            res += Math.abs(i + 1 - nums[i]);
        }
        System.out.println(res);
    }
}
