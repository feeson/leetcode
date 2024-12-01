package y23.m9.d17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solutionp4 {
    public int countWays(List<Integer> nums) {
        int len=nums.size();
        int res=0;
        boolean[]pass=new boolean[len+1];
        for (int val:nums){
            if (val<=len)
                pass[val]=true;
        }
        nums.sort(Comparator.comparingInt(a -> a));
        int cnt=1;
        for (int i=0;i<len-1;++i){
            if (nums.get(i)<cnt&&cnt<nums.get(i+1))
                res++;
            cnt++;
        }
        if (nums.get(len-1)<len)
            res++;
        if (0<nums.get(0))
            res++;
        return res;
    }
}