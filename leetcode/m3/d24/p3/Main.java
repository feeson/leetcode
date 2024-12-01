package y24.m3.d24.p3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int batch = Integer.parseInt(reader.readLine());
        for (int b = 0;b<batch;++b){
            int len = Integer.parseInt(reader.readLine());
            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (len == 1){
                System.out.println(nums[0]);
                continue;
            }else if (len == 2){
                System.out.println(nums[1]);
                continue;
            }
            // n>=4
            // 1. 送工具人过去
            // 2. 回来
            // 3. 两个最大的过去
            // 4. 工具人回来
            // 5. n -= 2
            // repeat
            // n = 3
            // 1. 送工具人过去
            // 2. 回来
            // 3. n = 2
            // n = 2
            // 1. 送工具人
            int sum = 0;
            int index = len-1;
            while (index >= 0){
                if (index >= 3){
                    int h1 = nums[index];
                    int h2 = nums[index-1];
                    int l1 = nums[0];
                    int l2 = nums[1];
                    int v1 = h1 + h2 + 2*l1;
                    int v2 = 2*l2 + h1 + l1;
                    sum+=Math.min(v1,v2);
                    index-=2;
                }else if (index == 2){
                    int h1 = nums[index];
                    int l1 = nums[0];
                    sum += h1 + l1;
                    index--;
                }else{
                    // 1,0
                    sum+=nums[index];
                    index-=2;
                }
            }
            System.out.println(sum);
        }
    }
}
