package y24.m3.d20.p3;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeMap;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int index = 0;
        int adder = 0;
        while(index < len){
            int num = nums[index];
            int numCnt = cal(nums,index);
            index += numCnt;
            if (adder != 0){
                numCnt+=adder;
                adder = 0;
            }
            int add = numCnt/2;
            sum += add;
            if (index >= len){
                while (add >= 2){
                    sum += add/=2;
                }
                break;
            }
            int nxtVal = nums[index];
            while (nxtVal != num+1){
                if (add < 2){
                    add = 0;
                    break;
                }
                add /= 2;
                sum += add;
                nxtVal++;
            }
            adder += add;
        }
        System.out.println(sum);
    }
    static int cal(int[] nums,int index){
        int len = nums.length;
        if(index >= len)
            return len;
        int num = nums[index];
        int res = 0;
        while(index < len && nums[index++] == num){
            res++;
        }
        return res;
    }
}