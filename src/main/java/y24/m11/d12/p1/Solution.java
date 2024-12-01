package y24.m11.d12.p1;
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int count0 = chars[0] == '0'?1:0;
        int count1 = chars[0] == '1'?1:0;
        int len = s.length();
        int res = 0;
        while(l < len){
            while(r < len && (count0 <= k || count1 <= k)){
                r++;
                if(r < len){
                    if(chars[r] == '0')
                        count0++;
                    else
                        count1++;
                }
            }
            res+=(r-l);
            count0 -= chars[l] == '0'?1:0;
            count1 -= chars[l] == '1'?1:0;
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.countKConstraintSubstrings("10101",1);
    }
}