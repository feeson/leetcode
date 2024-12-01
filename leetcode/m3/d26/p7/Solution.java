package y24.m3.d26.p7;

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        for (int val:nums){
            f(val);
        }
        int res = 0;
        for (int i = 2; i < 1007;++i){
            if (cnt[i] > 0 && isPrime(i))
                res++;
        }
        return res;
    }
    int[] cnt = new int[1007];
    boolean isPrime(int n) {
        if(n <= 3 && n > 1) {
            return true;
        }
        //不在6的倍数两侧的一定不是素数
        if((n % 6 != 1) && (n % 6 != 5)) {
            return false;
        }
        for(int i = 5; i <= Math.sqrt(n); i+= 6) {
            if(n % i == 0 || n %(i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    void f(int num){
        if (isPrime(num)){
            cnt[num]++;
            return;
        }
        for (int i = 2; i < num;++i){
            while (num % i == 0){
                cnt[i]++;
                num/=i;
            }
        }
        if (num >= 2)
            cnt[num]++;
    }
}
class Main{
    public static void main(String[] args) {
        int[] arr =new int[]{2,4,3,7,10,6};
        Solution solution =new Solution();
        solution.distinctPrimeFactors(arr);
    }
}