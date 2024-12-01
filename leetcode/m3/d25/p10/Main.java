package y24.m3.d25.p10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] diff = new int[len];
        // 差表
        for (int i = 0; i < len;++i){
            if (nums[i] == 1){
                diff[i]++;
            }else {
                diff[i]++;
                if (i - 1 >= 0)
                    diff[i-1]++;
            }
        }
        int sum = 0;
        int[] ticket = new int[len];
        for (int i = len-1;i >= 0;i--){
            sum+=diff[i];
            ticket[i] = sum;
        }
        for (int val:ticket)
            System.out.println(val);
    }
}
