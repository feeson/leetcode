package y24.m5.d5.p4;

class Solution {
    int m;
    int n;
    int numSelect;
    int[] nums;

    public int maximumRows(int[][] matrix, int numSelect) {
        n = matrix.length;
        m = matrix[0].length;
        this.numSelect = numSelect;
        nums = new int[n];
        for (int i = 0;i < n; ++i){
            int num = 0;
            for (int j = 0;j < m; ++j){
                if (matrix[i][j] == 1){
                    num += 1<<j;
                }
            }
            nums[i] = num;
        }
        // 构造所选列
        return dfs(0,numSelect,0);
    }
    int dfs(int pat, int left, int s){
        int ans = 0;
        if (s + left > m)
            return 0;
        if (left == 0){
            for (int i = 0;i < n; ++i){
                if ((pat & nums[i]) == nums[i])
                    ans++;
            }
            return ans;
        }
        for (int i = s; i < m; ++i){
            int val = pat;
            val += 1<<i;
            int res = dfs(val, left - 1, i + 1);
            ans = Math.max(ans, res);
        }
        return ans;
    }
}