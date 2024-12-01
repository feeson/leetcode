package y24.m3.d23.p8;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int len = nums.length;
        int res = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0;i < len;++i){
            if (deque.isEmpty()){
                deque.addLast(new int[]{nums[i],1});
                continue;
            }
            if (nums[i] > deque.peekLast()[0]){
                deque.addLast(new int[]{nums[i],1});
            }else if (nums[i] == deque.peekLast()[0]){
                deque.peekLast()[1]++;
            }else {

            }
            if (deque.size() == 2){
                
            }
        }
        HashMap map =new HashMap();
        System.out.println(res);
    }
}
