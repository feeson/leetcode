package y24.m3.d24.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] line0 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line0[0];
        int m = line0[1];
        int[][]nums = new int[n][m];
        for (int i = 0;i < n;++i){
            nums[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int code0 = 0;
        Map<Long,Integer> map = new HashMap<>();
        for (int i = 0;i < n;++i){
            long code = 0;
            int start = nums[i][0];
            for (int j = 1;j < m;++j){
                code+=(nums[i][j] - start);
                code*=100;
            }
            if (code == 0){
                code0++;
            }else {
                int v = map.getOrDefault(code,0);
                map.put(code,v+1);
            }
        }
        long res = 0;
        for (Map.Entry<Long,Integer> entry:map.entrySet()){
            int v1 = entry.getValue();
            int v2 = map.getOrDefault(-entry.getKey(),0);
            res+= (long) v1 * v2;
        }
        res/=2;
        res+= (long) (code0 - 1) *code0/2;
        System.out.println(res);
    }
}
