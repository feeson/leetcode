package y23.m10.d29;

class Solutionp3 {
    public int findKOr(int[] nums, int k) {
        int max=-1;
        int len=nums.length;
        for(int i=0;i<len;++i)
            max=Math.max(max,nums[i]);
        int tar=0;
        for(int i=0;i<32;++i){
            int times=0;
            for(int j=0;j<len&&times<k;++j){
                if(((1<<i)&nums[j])!=0)
                    times++;
            }
            if(times>=k)
                tar+=1<<i;
        }
        return tar;
    }
}