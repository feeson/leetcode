package y24.m3.d25.p8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        int left = 0;
        int right = len -1;
        int[] sorted = new int[len];
        int index = 0;
        while (left <= right){
            sorted[index++] = nums[left++];
            if (index < len)
                sorted[index++] = nums[right--];
        }
        long sum = Math.abs(sorted[0] - sorted[len-1]);
        for (int i = 1; i < len;++i){
            sum += Math.abs(sorted[i] - sorted[i -1]);
        }
        System.out.println(sum);
        for (int i = 0;i < len -1 ;++i){
            System.out.print(sorted[i]+" ");
        }
        System.out.println(sorted[len - 1]);
    }
}
