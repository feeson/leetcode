package y23.m11.d21;

class Solutionp3 {
    public long minimumSteps(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        int l=len,r=len-1;
        long cnt = 0;
        while (l>=0){
            while (r>=0 && c[r]=='1')
                r--;
            if (l>r)
                l =r;
            while (l >=0 && c[l]=='0')
                l--;
            if (l >=0){
                cnt+=(r-l);
                c[l] = '0';
                c[r] ='1';
            }
        }
        return cnt;

    }
}