package jiqiao.STbiao;

public class Main {
    // ST RMQ
    class ST{
        int len;
        int[][] st;
        int log2len;
        ST(int len,int[] nums){
            this.len = len;
            log2len = (int) Math.ceil((Math.log10(len)/Math.log10(2)));
            init(nums);
        }
        void init(int[] nums){
            for (int i = 0;i < len;++i)
                st[i][0] = nums[i];
            for (int j = 1; j <= log2len;j++){
                for (int i = 0;i + (1<<j)<=len;++i){
                    st[i][j] = Math.max(st[i][j-1],st[i +(1<<j - 1)][j - 1]);
                }
            }
        }
        int find(int l,int r){
            // [)
            // r - l >= 2^k
            int k = (int) (Math.log10(r - l)/Math.log10(2));
            return Math.max(st[l][k],st[r - (1<<k)][k]);
        }
    }
}
