package y24.m3.d18.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = reader.readLine().split(" ");
        int len = Integer.parseInt(fst[0]);
        int qLen = Integer.parseInt(fst[1]);
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long cnt0 = 0;
        long sum =0;
        for (int val:nums){
            if (val == 0)
                cnt0++;
            sum += val;
        }
        for (int i=0;i<qLen;++i){
            String[] readLine = reader.readLine().split(" ");
            long idx0 = Integer.parseInt(readLine[0]);
            long idx1 = Integer.parseInt(readLine[1]);
            System.out.println((sum + cnt0 *idx0)+" "+(sum + cnt0*idx1));
        }
    }
}
