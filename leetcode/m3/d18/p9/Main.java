package y24.m3.d18.p9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(reader.readLine());
//        int[] nums = Arrays.stream((reader.readLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] nums = new int[st.countTokens()];
        int index = 0;
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            try {
                nums[index++] = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                // handle the exception
            }
        }
        int res =Integer.MAX_VALUE;
        dic = new int[n][n][n];
        for (int i = 0;i<n;++i){
            res =Math.min(res,dfs(nums,i,0,n-1));
        }
        System.out.println(res);
    }
    // i是根节点的结果
    static int[][][] dic;
    // 在left - right中选择root为根节点的最小化结果
    static int dfs(int[] nums,int root,int left,int right){
        if (right - left == 0){
            dic[root][left][right] = 0;
            return 0;
        }
        if (dic[root][left][right] != 0)
            return dic[root][left][right];
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        // 计算左子树
        for (int i=left;i<root;++i){
            int val = dfs(nums,i,left,root-1) + nums[i] * nums[root];
            leftMin = Math.min(leftMin,val);
        }
        if (leftMin == Integer.MAX_VALUE)
            leftMin = 0;
        for (int i = root+1;i<=right;++i){
            int val = dfs(nums,i,root+1,right) + nums[i] * nums[root];
            rightMin =  Math.min(rightMin,val);
        }
        if (rightMin == Integer.MAX_VALUE)
            rightMin = 0;
        int res = leftMin + rightMin;
        dic[root][left][right] = res;
        return  res ;
    }
}
