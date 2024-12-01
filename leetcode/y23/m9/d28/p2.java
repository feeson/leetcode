package y23.m9.d28;

class Solution {
    public int minDistance(String word1, String word2) {
        char[] s = word1.toCharArray(), t = word2.toCharArray();
        int len1 = s.length, len2 = t.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int j = 1; j <= len2; ++j) dp[0][j] = j;
        for (int i = 0; i < len1; ++i) {
            dp[i + 1][0] = i + 1;
            for (int j = 0; j < len2; ++j)
                dp[i + 1][j + 1] = s[i] == t[j] ? dp[i][j] :
                        Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
        }
        //打印
        System.out.print("     ");
        for (int i=0;i<len2;++i){
            System.out.print(word2.charAt(i)+" ");
        }
        System.out.println();
        for (int i=0;i<=len1;++i){
            if (i!=0)
                System.out.print(word1.charAt(i-1)+" ");
            else
                System.out.print("  ");
            for (int j=0;j<=len2;++j)
                System.out.print(" "+dp[i][j]);
            System.out.println();
        }
        return dp[len1][len2];
    }

//    public static void main(String[] args) {
//        Solution solution=new Solution();
//        solution.minDistance("translate","too-late");
//    }
}