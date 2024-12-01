package y22.m10.d10.p1;

/**
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 *
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 *
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 *
 * 注意：
 *
 * 用例保证可以实现操作。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    int[] nums1;
    int[] nums2;
    public static void main(String[] args) {

    }

    /**
     *
     *
     * nums1[i]>nums1[i-1]且nums2[i]>nums2[i-1]
     * nums1[i]>nums2[i-1]且nums2[i]>nums1[i-1]
     * @param nums1
     * @param nums2
     * @return
     */
    public int minSwap(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;

        for (int i=1;i<nums1.length;++i){
            if (checkFirst(i)&&checkSecond(i)){

            }else if (checkFirst(i)&&!checkSecond(i)){

            }else{

            }
        }
        return 0;
    }
    boolean checkFirst(int index){
        return nums1[index]>nums1[index-1]&&nums2[index]>nums2[index-1];
    }
    boolean checkSecond(int index){
        return nums1[index]>nums2[index-1]&&nums2[index]>nums1[index-1];
    }
}