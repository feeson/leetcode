package y24.m3.d23.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[len + 1];
        for (int i = 0;i <len;++i){
            arr[i + 1] = nums[i];
        }
        int[] color = Arrays.stream(reader.readLine().split("")).mapToInt((c)->{
            if (c.equals("W"))
                return 0;
            else
                return 1;
        }).toArray();
        int wrongPos = 0;
        int[] numsIndex = new int[len + 1];
        for (int i = 1;i <=len; ++i){
            numsIndex[arr[i]] = i;
            if (arr[i] != i && color[i - 1] == 0){
                System.out.println(-1);
                return;
            }
            if (arr[i] != i)
                wrongPos++;
        }
        int res = 0;
        for (int i = 1;i <= len;++i){
            if (arr[i] != i){
                // 配对
                int val = arr[i];
                if (arr[numsIndex[val]] == i){
                    wrongPos -=2;
                    res++;
                    arr[i] = i;
                    arr[numsIndex[i]] = val;
                }
            }
        }
        if (wrongPos != 0)
            res += wrongPos-1;
        System.out.println(res);
    }
}
