package y23.m4.d3;

/**
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/previous-permutation-with-one-swap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int len=arr.length;
        if (len==1)
            return arr;
        int indexLeft=len-2;
        int tmp1=arr[indexLeft];
        int max=0;
        int index=-1;
        do {
            tmp1=arr[indexLeft];
            for (int i=indexLeft+1;i<len;++i){
                if (tmp1>arr[i]){
                    if (arr[i]>max){
                        max=arr[i];
                        index=i;
                    }
                }
            }
            if (index!=-1){
                tmp1=arr[index];
                arr[index]=arr[indexLeft];
                arr[indexLeft]=tmp1;
                return arr;
            }
            indexLeft--;
        }while (indexLeft>=0);
        return arr;
    }
}