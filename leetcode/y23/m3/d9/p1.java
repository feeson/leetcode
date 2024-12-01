package y23.m3.d9;

/**
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1 {
    public int minimumRecolors(String blocks, int k) {
//        int len=blocks.length();
//        int leftIndex=0;
//        int rightIndex=k-1;
//        int expense=0;
//        char[] block=blocks.toCharArray();
//        for (int i=0;i<k;++i){
//            if (block[i]=='W') {
//                expense++;
//            }
//        }
//        int min=expense;
//        while (expense!=0&&rightIndex!=len-1){
//            int delta=0;
//            if (block[leftIndex++]=='W')
//                delta--;
//            if (block[++rightIndex]=='W')
//                delta++;
//            expense+=delta;
//            min=Integer.min(expense,min);
//        }
//        return min;
        int len=blocks.length();
        int res=Integer.MAX_VALUE;
        for (int i=0;i<len-k+1;++i){
            int expense=0;
            for (int j=i;j<k;++j){
                if (blocks.charAt(i)=='W')
                    expense++;
            }
            res=Integer.min(res,expense);
        }
        return res;
    }
}