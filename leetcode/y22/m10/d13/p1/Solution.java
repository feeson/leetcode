package y22.m10.d13.p1;

/**
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 *
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 *
 * 返回数组能分成的最多块数量。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-chunks-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{1,0,2,3,4}));
    }
    public static int maxChunksToSorted(int[] arr) {
        boolean inBlock=false;
        int minus=Integer.MAX_VALUE;
        int max=-1;
        int lengthOfBlock=0;
        int res=0;
        int start=-1;
        for (int i=0;i<arr.length;++i){
            if (inBlock){
                lengthOfBlock++;
            }else {
                start=i;
                inBlock=true;
                lengthOfBlock=1;
            }
            minus=Integer.min(minus,arr[i]);
            max=Integer.max(max,arr[i]);
            if (max-minus+1==lengthOfBlock&&minus==start){
                res++;
                inBlock=false;
                minus=Integer.MAX_VALUE;
                max=-1;
            }
        }
        return res++;
    }
}