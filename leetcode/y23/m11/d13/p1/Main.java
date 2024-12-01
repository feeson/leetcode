package y23.m11.d13.p1;

import java.util.Scanner;

public class Main{
    int dfs(int[] nums){
        int len =nums.length;
        if (len <= 1)
            return nums[0];
        int res = -1;
        for (int i=0;i<len;++i){
            for (int j = i+1 ;j<len;++j){
                int[] next =new int[len-1];
                int cnt = 1;
                for (int k = 0;k<len;++k){
                    if (k != i && k != j){
                        next[cnt++] = nums[k];
                    }
                }
                next[0] = nums[i]+nums[j];
                res = check(res,dfs(next));
                if (res == 24)
                    return 24;
                next[0] = nums[i]-nums[j];
                res = check(res,dfs(next));
                if (res == 24)
                    return 24;
                next[0] = nums[j]-nums[i];
                res = check(res,dfs(next));
                if (res == 24)
                    return 24;
                next[0] = nums[i]*nums[j];
                res = check(res,dfs(next));
                if (res == 24)
                    return 24;
                if (nums[i] != 0 && nums[j] % nums[i] == 0){
                    next[0] = nums[j]/nums[i];
                    res = check(res,dfs(next));
                    if (res == 24)
                        return 24;
                }
                if (nums[j] != 0 && nums[i] % nums[j] == 0){
                    next[0] = nums[i]/nums[j];
                    res = check(res,dfs(next));
                    if (res == 24)
                        return 24;
                }
            }
        }
        return res;
    }
    int check(int res,int val){
        if (val>=0&&val<=24)
            return Math.max(res,val);
        return res;
    }
    public static void main(String[] args) {
        Main p2=new Main();
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int[][]arr=new int[row][4];
        int[] res = new int[row];
        for (int i = 0 ;i <row;++i){
            for (int j = 0 ;j<4 ;++j){
                arr[i][j] = scanner.nextInt();
            }
            res[i] = p2.dfs(arr[i]);
        }
        for (int val : res)
            System.out.println(val);
    }
}