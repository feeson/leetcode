package y24.m8.d18.p2;

public class p1 {
    int[] nums;
    int lowbit(int val){
        return val&(-val);
    }
    void modify(int index, int val){
        while (index < nums.length){
            nums[index] += val;
            index += lowbit(index);
        }
    }

    int sum(int index){
        int res = 0;
        while (index >= 0){
            res += nums[index];
            index -= lowbit(index);
        }
        return res;
    }
}
