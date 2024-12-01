package y24.m3.d23.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = line0[0];
        int n = line0[1];
        int[][] nums = new int[m][n];
        for (int i = 0;i < m;++i){
            nums[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        int res = 0;
        for (int i = 0;i < m - 1;i++){
            for (int j = 0 ;j < n - 1;++j){
                int cnt0 = 0;
                int cnt1 = 0;
                for (int x = 0;x < 2;++x){
                    for (int y = 0;y < 2;++y){
                        if (nums[i + x][j + y] == 0)
                            cnt0++;
                        else
                            cnt1++;
                    }
                }
                if (cnt0 == cnt1)
                    res++;
            }
        }
        System.out.println(res);
    }
}
