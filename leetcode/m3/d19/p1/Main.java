package y24.m3.d19.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int groupCnt = Integer.parseInt(reader.readLine());
        for (int group = 0;group < groupCnt;group++){
            int len = Integer.parseInt(reader.readLine());
            int[][] nums = new int[len][2];
            int[] a1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] a2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i=0;i<len;++i){
                nums[i][0] = a1[i];
                nums[i][1] = a2[i];
            }
            Arrays.sort(nums,(o1,o2)->{
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            });
            int res = 0;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i=0;i<len;++i){
                if (i == 0){
                    deque.addLast(nums[i][1]);
                    continue;
                }
                while (!deque.isEmpty() && nums[i][1] <= deque.peekLast()){
                    deque.pollLast();
                }
                deque.addLast(nums[i][1]);
                res = Math.max(res,deque.size());
            }
            System.out.println(res);
        }
    }
}
