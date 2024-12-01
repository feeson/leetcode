package y24.m3.d20.p1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int val:nums){
            sum += val;
        }
        if (sum % 2 != 0){
            System.out.println(0);
            return;
        }
        List<Integer> list = new ArrayList<>();
        for (int i =0;i<n;++i){
            list.add(i);
        }
        int target = sum / 2;
        for (int i =0;i<n;++i){
            if (dfs(nums,list,0,target)){
                System.out.println(target);
                return;
            }
        }
        System.out.println(0);
    }
    static boolean dfs(int[]nums, List<Integer> list,int val,int target){
        if (list.isEmpty())
            return false;
        int len = list.size();
        for (int i = 0;i<len;++i){
            int index = list.get(i);
            int res = nums[index] + val;
            list.remove(i);
            if (res == target)
                return true;
            if (dfs(nums,list,res,target))
                return true;
            list.add(i,index);
        }
        return false;
    }
}
