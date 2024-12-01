package y23.m11.d22.three;

import javax.naming.spi.DirObjectFactory;
import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = Integer.parseInt(scanner.nextLine());
        int[] res = new int[total];
        for (int i=0;i<total;++i){
            int len= Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            int cnt = 0;
            int[] nums = new int[len];
            for (String str:s.split(" "))
                nums[cnt++] = Integer.parseInt(str);
            res[i] = getIndex(nums,len);
        }
        for (int val:res)
            System.out.println(val);
    }
    static int getIndex(int[] nums,int len){
        for (int i=0;i<len;++i){
            int sum = nums[i];
            int l =i-1,r=i+1;
            while (l>=0 || r<len){
                if (l>=0&&r<len){
                    if (sum<=nums[l]&&sum<=nums[r])
                        break;
                }else {
                    if (l<0){
                        if (sum<=nums[r])
                            break;
                    }else{
                        if (sum<=nums[l])
                            break;
                    }
                }
                while (l>=0 &&sum>nums[l]){
                    sum++;
                    l--;
                }
                while (r<len && sum>nums[r]){
                    sum++;
                    r++;
                }
            }
            if (l<0&&r>=len)
                return i;
        }
        return -1;
    }
}
