package y24.m3.d30.meituan.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringJoiner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = nums[0];
        for (int val:nums){
            max = Integer.max(max,val);
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int val:nums){
            if (val * 2 > max)
                stringJoiner.add(Integer.toString(val * 2));
            else
                stringJoiner.add(Integer.toString(max));
        }
        System.out.println(stringJoiner);
    }
}