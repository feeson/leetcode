package y22.m10.d06.p1;

import com.sun.nio.sctp.SendFailedNotification;

import javax.print.DocFlavor;

/**
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 *
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 *
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 *
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/three-equal-parts
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int length= arr.length;
        int timesOf1=0;
        int firstOf1=-1;
        StringBuilder arrSb=new StringBuilder();
        for (int i=0;i<length;++i){
            arrSb.append(arr[i]);
            if (arr[i]==1){
                timesOf1++;
            }
            if (firstOf1==-1&&arr[i]==1){
                firstOf1=i;
            }
        }
        if (firstOf1==-1){
            return new int[]{0,arr.length-1};
        }
        if (timesOf1%3!=0){
            return new int[]{-1,-1};
        }else {
            timesOf1=timesOf1/3;
        }

        int markedOf1=0;
        int uniqueLengthHead=0;
        for (int i=firstOf1;i<length;++i){
            if (arr[i]==1){
                markedOf1++;
                if (markedOf1==timesOf1){
                    uniqueLengthHead=i-firstOf1+1;
                    break;
                }
            }
        }
        markedOf1=0;
        int uniqueEndIndex=0;
        int numsOfLastOf0=0;
        boolean meet1=false;
        for (int i=1;i<=length;++i){
            if (arr[length-i]==1){
                meet1=true;
                markedOf1++;
                if (markedOf1==timesOf1){
                    uniqueEndIndex=length-i;
                    break;
                }
            }else {
                if (!meet1){
                    numsOfLastOf0++;
                }
            }
        }

        int resI=-1;
        int resJ=-1;
        int movedTimes=0;
        String head= arrSb.toString().substring(firstOf1,firstOf1+uniqueLengthHead);
        String mid=arrSb.toString().substring(firstOf1+uniqueLengthHead,uniqueEndIndex);
        String end=arrSb.toString().substring(uniqueEndIndex);
        //处理end后置0
        for (int i=1;i<=end.length();++i){
            if (end.charAt(end.length()-i)=='0'){
                if (mid.charAt(0)=='0'){
                    head=head+"0";
                    mid=mid.substring(1);
                    movedTimes++;
                }else {
                    return new int[]{-1,-1};
                }
            }else {
                break;
            }
        }
        if (!head.equals(end)){
            return new int[]{-1,-1};
        }else {
            resI=firstOf1+uniqueLengthHead-1+movedTimes;
        }
        //处理mid前置0
        for (int i=0;i<mid.length();++i){
            if (mid.charAt(i)=='1'){
                mid=mid.substring(i);
                break;
            }
            movedTimes++;
        }

        for (int i=0;i<mid.length();++i){
            if (head.equals(mid.substring(0,mid.length()-i))){
                resJ=firstOf1+uniqueLengthHead+mid.length()-i+movedTimes;
                break;
            }
        }
        if (resJ==-1){
            return new int[]{-1,-1};
        }else {
            return new int[]{resI,resJ};
        }
    }
}