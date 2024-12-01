package y24.m8.baidu.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] clocks = reader.readLine().split(" ");
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = clocks[i].split(":");
            nums[i][0] = Integer.parseInt(s[0]);
            nums[i][1] = Integer.parseInt(s[1]);
            nums[i][2] = Integer.parseInt(s[2]);
        }
        double[] res = new double[n];
        for (int i = 1; i < n; i++) {
            double roundF = 60 * nums[i - 1][0] + nums[i - 1][1] + (double)nums[i - 1][2] / 60;
            double roundS = 60 * nums[i][0] + nums[i][1] + (double)nums[i][2] / 60;
            boolean incre = false;
            if (nums[i][0] < nums[i - 1][0]){
                incre = true;
            }else if (nums[i][0] == nums[i - 1][0]){
                if (nums[i][1] < nums[i - 1][1]){
                    incre = true;
                }else if (nums[i][1] == nums[i - 1][1]){
                    if (nums[i][2] < nums[i - 1][2]){
                        incre = true;
                    }
                }
            }
            if (incre){
                roundS += 60 * 24;
            }
            res[i] = roundS - roundF;
        }
        StringJoiner sj = new StringJoiner("\n","","\n");
        for (int i = 1; i < n; i++) {
            sj.add(String.format("%.10f",res[i]));
        }
        System.out.println(sj);
    }
}
