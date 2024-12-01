package y23.m9.d17;

import java.util.List;

class Solutionp3 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int len=nums.size();
        int res=0;
        for (int i=0;i<len;++i){
            int t=i;
            int count = 0;
            while(t != 0){
                count += t & 1;
                t >>>= 1;
            }
            if (count==k)
                res+=nums.get(i);
        }
        return res;
    }
}